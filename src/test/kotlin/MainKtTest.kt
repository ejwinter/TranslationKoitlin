import com.winteredge.transcription.GeneticCodeRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    internal fun findProteinAllProteins(){
        val standardCode = GeneticCodeRepository().findCode("standard")?:throw IllegalStateException()
        val proteins = findProteinAllProteins("AGGACGGGCTAACTCCGCTCGTCACAAAGCGCAATGCAGCTATGGCAGATGTTCATGCCG", standardCode)
        assertEquals(1, proteins.size);
        assertEquals("MNICHSCIALCDERS", proteins[0])
    }
}