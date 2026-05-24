// port-lint: source desktop_env.rs
package io.github.kotlinmania.whoami

// FIXME: V2: Move `Unknown` variants to the top of the enum.

/**
 * The desktop environment of a system.
 */
public sealed class DesktopEnv {
    /**
     * Popular GTK-based desktop environment on Linux.
     */
    public data object Gnome : DesktopEnv()

    /**
     * One of the desktop environments for a specific version of Windows.
     */
    public data object Windows : DesktopEnv()

    /**
     * Linux desktop environment optimized for low resource requirements.
     */
    public data object Lxde : DesktopEnv()

    /**
     * Stacking window manager for X Windows on Linux.
     */
    public data object Openbox : DesktopEnv()

    /**
     * Desktop environment for Linux, BSD and illumos.
     */
    public data object Mate : DesktopEnv()

    /**
     * Lightweight desktop environment for Unix-like operating systems.
     */
    public data object Xfce : DesktopEnv()

    /**
     * KDE Plasma desktop environment.
     */
    // FIXME: Rename to `Plasma` in whoami 2.0.0.
    public data object Kde : DesktopEnv()

    /**
     * Default desktop environment on Linux Mint.
     */
    public data object Cinnamon : DesktopEnv()

    /**
     * Tiling window manager for Linux.
     */
    public data object I3 : DesktopEnv()

    /**
     * Desktop environment for MacOS.
     */
    public data object Aqua : DesktopEnv()

    /**
     * Desktop environment for iOS.
     */
    public data object Ios : DesktopEnv()

    /**
     * Desktop environment for Android.
     */
    public data object Android : DesktopEnv()

    /**
     * Running as Web Assembly on a web page.
     */
    public data object WebBrowser : DesktopEnv()

    /**
     * A desktop environment for a video game console.
     */
    public data object Console : DesktopEnv()

    /**
     * Ubuntu-branded GNOME.
     */
    public data object Ubuntu : DesktopEnv()

    /**
     * Default shell for Fuchsia.
     */
    public data object Ermine : DesktopEnv()

    /**
     * Default desktop environment for Redox.
     */
    public data object Orbital : DesktopEnv()

    /**
     * Unknown desktop environment.
     */
    public data class Unknown(public val name: String) : DesktopEnv()

    private fun fmt(): String =
        when (this) {
            Gnome -> "Gnome"
            Windows -> "Windows"
            Lxde -> "LXDE"
            Openbox -> "Openbox"
            Mate -> "Mate"
            Xfce -> "XFCE"
            Kde -> "KDE"
            Cinnamon -> "Cinnamon"
            I3 -> "I3"
            Aqua -> "Aqua"
            Ios -> "IOS"
            Android -> "Android"
            WebBrowser -> "Web Browser"
            Console -> "Console"
            Ubuntu -> "Ubuntu"
            Ermine -> "Ermine"
            Orbital -> "Orbital"
            is Unknown -> "Unknown: $name"
        }

    final override fun toString(): String = fmt()

    /**
     * Returns true if the desktop environment is based on GTK.
     */
    public fun isGtk(): Boolean =
        this == Gnome ||
            this == Ubuntu ||
            this == Cinnamon ||
            this == Lxde ||
            this == Mate ||
            this == Xfce

    /**
     * Returns true if the desktop environment is based on KDE.
     */
    public fun isKde(): Boolean = this == Kde
}
