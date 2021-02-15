import com.winteredge.transcription.GeneticCode
import com.winteredge.transcription.GeneticCodeRepository

private val crossmap = mapOf(
    "A" to "T",
    "T" to "A",
    "G" to "C",
    "C" to "G"
)

fun complement(seq: String) : String {
    return seq.toCharArray()
       .map { i -> crossmap[i.toString()] }
       .joinToString("")
}

fun main(args: Array<String>) {
    val dna = args[0].toUpperCase()
    val codeName = args[1].toLowerCase()
    val code = GeneticCodeRepository().findCode(codeName)?:throw IllegalStateException("No such genetic code: $codeName")

    val proteinOptions = findProteinAllProteins(dna, code);
    proteinOptions.forEach { o -> println(o) }
}

fun findProteinAllProteins(dna: String, code: GeneticCode): List<String> {
    return listOf(dna, complement(dna.reversed()))
        .map { s -> s.replace("T", "U") }
        //get all possible frameshifts
        .flatMap { mrna -> (0..mrna.length-1).map { i -> mrna.substring(i) }}
        .map { mrna -> code.translate(mrna) }
        .filter { aa -> aa.startsWith("M") }
        .filter { mrna -> mrna.contains("X") }
        .map { mrna -> mrna.subSequence(0, mrna.indexOf("X")).toString() }
}
