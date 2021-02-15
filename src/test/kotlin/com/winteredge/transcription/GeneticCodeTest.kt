package com.winteredge.transcription

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GeneticCodeTest {

    val standardCode : GeneticCode = initStandardCode()

    private fun initStandardCode(): GeneticCode {
        return GeneticCodeRepository().findCode("standard")?: throw IllegalStateException()
    }


    @Test
    internal fun `simple single code transcription`() {
        assertEquals("Met", standardCode.translate("AUG"))
    }

    @Test
    internal fun `three full codons`(){
        assertEquals("MetPheIle", standardCode.translate("AUGUUUAUU"))
    }

    @Test
    internal fun `three full codons plus extra`(){
        assertEquals("MetPheIle", standardCode.translate("AUGUUUAUUAU"))
    }

}