// port-lint: source arch.rs
package io.github.kotlinmania.whoami

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ArchTest {
    @Test
    fun displayNamesMatchUpstream() {
        assertEquals("armv5", Arch.ArmV5.toString())
        assertEquals("arm64", Arch.Arm64.toString())
        assertEquals("x86_64", Arch.X64.toString())
        assertEquals("Unknown: mystery", Arch.Unknown("mystery").toString())
    }

    @Test
    fun widthsMatchUpstreamGroups() {
        assertEquals(Width.Bits32, Arch.ArmV7.width().getOrThrow())
        assertEquals(Width.Bits32, Arch.I686.width().getOrThrow())
        assertEquals(Width.Bits64, Arch.Arm64.width().getOrThrow())
        assertEquals(Width.Bits64, Arch.S390x.width().getOrThrow())
        assertTrue(Arch.Unknown("mystery").width().isFailure)
    }
}
