// port-lint: source platform.rs
package io.github.kotlinmania.whoami

/**
 * The underlying platform for a system.
 */
public sealed class Platform {
    public data object Linux : Platform()

    public data object Bsd : Platform()

    public data object Windows : Platform()

    // FIXME: Non-standard casing; rename to `Mac` rather than `MacOs` in whoami 2.0.0.
    public data object MacOS : Platform()

    public data object Illumos : Platform()

    public data object Ios : Platform()

    public data object Android : Platform()

    // FIXME: Separate for different Nintendo consoles in whoami 2.0.0; currently only used for 3DS.
    public data object Nintendo : Platform()

    // FIXME: Currently unused, remove in whoami 2.0.0.
    public data object Xbox : Platform()

    public data object PlayStation : Platform()

    public data object Fuchsia : Platform()

    public data object Redox : Platform()

    public data object Hurd : Platform()

    public data class Unknown(
        public val platform: String,
    ) : Platform()

    private fun fmt(): String =
        when (this) {
            Linux -> "Linux"
            Bsd -> "BSD"
            Windows -> "Windows"
            MacOS -> "Mac OS"
            Illumos -> "illumos"
            Ios -> "iOS"
            Android -> "Android"
            Nintendo -> "Nintendo"
            Xbox -> "XBox"
            PlayStation -> "PlayStation"
            Fuchsia -> "Fuchsia"
            Redox -> "Redox"
            Hurd -> "GNU Hurd"
            is Unknown -> "Unknown: $platform"
        }

    final override fun toString(): String = fmt()
}
