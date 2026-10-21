import Testing
import Whoami

@Suite("Whoami Swift Export Tests")
struct WhoamiExportTests {
    @Test func architectureDisplayNames() {
        #expect(Arch.Arm64.shared.toString() == "arm64")
        #expect(Arch.X64.shared.toString() == "x86_64")
        #expect(Arch.Unknown(arch: "custom").toString() == "Unknown: custom")
    }

    @Test func platformDisplayNames() {
        #expect(Platform.Linux.shared.toString() == "Linux")
        #expect(Platform.MacOS.shared.toString() == "Mac OS")
        #expect(Platform.Unknown(platform: "custom").toString() == "Unknown: custom")
    }

    @Test func languageCountryAndDisplay() {
        let english = Language.En(country: .Us)
        #expect(english.toString() == "en/US")
        #expect(english.country == .Us)
        #expect(Language.Es(country: .AnyCountry).toString() == "es")
        let custom = Language.Custom(code: "zz/custom")
        #expect(custom.code == "zz/custom")
        #expect(custom.toString() == "zz/custom")
        #expect(custom.country() == .AnyCountry)
    }

    @Test func countryAndWidthDisplay() {
        #expect(Country.AnyCountry.toString() == "**")
        #expect(Country.Us.toString() == "US")
        #expect(Width.Bits32.toString() == "32 bits")
        #expect(Width.Bits64.toString() == "64 bits")
    }
}
