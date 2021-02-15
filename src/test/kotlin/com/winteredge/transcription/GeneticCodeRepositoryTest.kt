package com.winteredge.transcription

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GeneticCodeRepositoryTest {

    @Test
    internal fun `We should initialized form our library to get standard code`() {
        val repo = GeneticCodeRepository();
        assertEquals("Met", repo.findCode("standard")?.translate("AUG"))
    }
}