package com.winteredge.transcription

import com.fasterxml.jackson.databind.ObjectMapper

class GeneticCodeRepository {

    val codes: Map<String, GeneticCode>;

    init {
        val simpleMap = ObjectMapper().readValue(javaClass.getResourceAsStream("/genetic-codes/genetic-codes.json"), MutableMap::class.java) as MutableMap<String, Map<String, String>>
        codes = simpleMap.mapValues {v-> GeneticCode(v.key, v.value)}

    }

    fun findCode(name: String): GeneticCode?{
        return codes[name];
    }
}