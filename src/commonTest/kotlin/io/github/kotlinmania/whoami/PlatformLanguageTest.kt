// port-lint: source platform.rs
package io.github.kotlinmania.whoami

import kotlin.test.Test
import kotlin.test.assertEquals

class PlatformLanguageTest {
    @Test
    fun platformDisplayNamesMatchUpstream() {
        assertEquals("Linux", Platform.Linux.toString())
        assertEquals("BSD", Platform.Bsd.toString())
        assertEquals("Mac OS", Platform.MacOS.toString())
        assertEquals("GNU Hurd", Platform.Hurd.toString())
        assertEquals("Unknown: custom", Platform.Unknown("custom").toString())
    }

    @Test
    fun languageDisplayNamesMatchUpstream() {
        assertEquals("**", Country.Any.toString())
        assertEquals("US", Country.Us.toString())
        assertEquals("en", Language.En(Country.Any).toString())
        assertEquals("en/US", Language.En(Country.Us).toString())
        assertEquals("es", Language.Es(Country.Any).toString())
        assertEquals("es/US", Language.Es(Country.Us).toString())
        assertEquals("zz/custom", Language.Custom("zz/custom").toString())
        assertEquals(Country.Any, Language.Custom("zz/custom").country())
        assertEquals(Country.Us, Language.En(Country.Us).country())
    }
}
