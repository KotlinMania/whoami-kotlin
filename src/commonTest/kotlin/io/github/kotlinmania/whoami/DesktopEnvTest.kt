// port-lint: source desktop_env.rs
package io.github.kotlinmania.whoami

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DesktopEnvTest {
    @Test
    fun displayNamesMatchUpstream() {
        assertEquals("Gnome", DesktopEnv.Gnome.toString())
        assertEquals("LXDE", DesktopEnv.Lxde.toString())
        assertEquals("Web Browser", DesktopEnv.WebBrowser.toString())
        assertEquals("Unknown: custom", DesktopEnv.Unknown("custom").toString())
    }

    @Test
    fun desktopEnvironmentFamiliesMatchUpstream() {
        assertTrue(DesktopEnv.Gnome.isGtk())
        assertTrue(DesktopEnv.Ubuntu.isGtk())
        assertTrue(DesktopEnv.Xfce.isGtk())
        assertFalse(DesktopEnv.Kde.isGtk())
        assertTrue(DesktopEnv.Kde.isKde())
        assertFalse(DesktopEnv.Gnome.isKde())
    }
}
