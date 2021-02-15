package com.winteredge.transcription

class GeneticCode(
    name: String,
    map: Map<String,String>
) {
    val name : String = name;
    private val map : Map<String,String> = map;

    fun translate(mrna: String) : String {
        return (0..mrna.length-1 step 3)
            .filter { i -> i + 3 <= mrna.length }
            .map { i -> map[mrna.subSequence(i, i + 3)] }
            .joinToString("");
    }
}