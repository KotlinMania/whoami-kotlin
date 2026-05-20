// port-lint: source arch.rs
package io.github.kotlinmania.whoami

/**
 * The address width of a CPU architecture.
 */
public enum class Width {
    /**
     * 32 bits.
     */
    Bits32,

    /**
     * 64 bits.
     */
    Bits64,
    ;

    override fun toString(): String =
        when (this) {
            Bits32 -> "32 bits"
            Bits64 -> "64 bits"
        }
}

/**
 * The architecture of a CPU.
 */
public sealed class Arch {
    /**
     * ARMv5.
     */
    public data object ArmV5 : Arch()

    /**
     * ARMv6. Sometimes just referred to as ARM.
     */
    public data object ArmV6 : Arch()

    /**
     * ARMv7. May or may not support Neon or Thumb.
     */
    public data object ArmV7 : Arch()

    /**
     * ARM64, also known as aarch64.
     */
    public data object Arm64 : Arch()

    /**
     * i386, or x86.
     */
    public data object I386 : Arch()

    /**
     * i586, or x86.
     */
    public data object I586 : Arch()

    /**
     * i686, or x86.
     */
    public data object I686 : Arch()

    /**
     * X86_64 or Amd64.
     */
    public data object X64 : Arch()

    /**
     * MIPS.
     */
    public data object Mips : Arch()

    /**
     * MIPS, little-endian.
     */
    public data object MipsEl : Arch()

    /**
     * MIPS64.
     */
    public data object Mips64 : Arch()

    /**
     * MIPS64, little-endian.
     */
    public data object Mips64El : Arch()

    /**
     * PowerPC.
     */
    public data object PowerPc : Arch()

    /**
     * PowerPC64.
     */
    public data object PowerPc64 : Arch()

    /**
     * PowerPC64LE.
     */
    public data object PowerPc64Le : Arch()

    /**
     * 32-bit RISC-V.
     */
    public data object Riscv32 : Arch()

    /**
     * 64-bit RISC-V.
     */
    public data object Riscv64 : Arch()

    /**
     * S390x.
     */
    public data object S390x : Arch()

    /**
     * SPARC.
     */
    public data object Sparc : Arch()

    /**
     * SPARC64.
     */
    public data object Sparc64 : Arch()

    /**
     * 32-bit Web Assembly.
     */
    public data object Wasm32 : Arch()

    /**
     * 64-bit Web Assembly.
     */
    public data object Wasm64 : Arch()

    /**
     * Unknown architecture.
     */
    public data class Unknown(public val arch: String) : Arch()

    final override fun toString(): String =
        when (this) {
            ArmV5 -> "armv5"
            ArmV6 -> "armv6"
            ArmV7 -> "armv7"
            Arm64 -> "arm64"
            I386 -> "i386"
            I586 -> "i586"
            I686 -> "i686"
            Mips -> "mips"
            MipsEl -> "mipsel"
            Mips64 -> "mips64"
            Mips64El -> "mips64el"
            PowerPc -> "powerpc"
            PowerPc64 -> "powerpc64"
            PowerPc64Le -> "powerpc64le"
            Riscv32 -> "riscv32"
            Riscv64 -> "riscv64"
            S390x -> "s390x"
            Sparc -> "sparc"
            Sparc64 -> "sparc64"
            Wasm32 -> "wasm32"
            Wasm64 -> "wasm64"
            X64 -> "x86_64"
            is Unknown -> "Unknown: $arch"
        }

    /**
     * Get the width of this architecture.
     */
    public fun width(): Result<Width> =
        when (this) {
            ArmV5,
            ArmV6,
            ArmV7,
            I386,
            I586,
            I686,
            Mips,
            MipsEl,
            PowerPc,
            Riscv32,
            Sparc,
            Wasm32,
            -> Result.success(Width.Bits32)

            Arm64,
            Mips64,
            Mips64El,
            PowerPc64,
            PowerPc64Le,
            Riscv64,
            S390x,
            Sparc64,
            Wasm64,
            X64,
            -> Result.success(Width.Bits64)

            is Unknown -> Result.failure(IllegalArgumentException("Tried getting width of unknown arch ($arch)"))
        }
}
