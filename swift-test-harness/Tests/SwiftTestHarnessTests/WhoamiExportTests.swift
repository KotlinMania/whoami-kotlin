#if canImport(Testing)
import Testing
import Whoami

@Suite("Whoami Swift Export Tests")
struct WhoamiExportTests {
    @Test("Whoami swift module imported cleanly")
    func testSwiftModuleLoads() throws {
        #expect(Bool(true), "Whoami swift module imported cleanly")
    }
}
#elseif canImport(XCTest)
import XCTest
import Whoami

final class WhoamiExportTests: XCTestCase {
    func testSwiftModuleLoads() throws {
        XCTAssertTrue(true, "Whoami swift module imported cleanly")
    }
}
#endif
