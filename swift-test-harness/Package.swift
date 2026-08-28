// swift-tools-version: 6.0
import PackageDescription

let package = Package(
    name: "SwiftTestHarness",
    platforms: [
        .macOS(.v14)
    ],
    dependencies: [
        .package(name: "Whoami", path: "../build/SPMPackage/macosArm64/Debug")
    ],
    targets: [
        .executableTarget(
            name: "SwiftTestHarnessTests",
            dependencies: [
                .product(name: "WhoamiLibrary", package: "Whoami")
            ],
            path: "Tests/SwiftTestHarnessTests",
            swiftSettings: [
                .unsafeFlags([
                    "-F", "/Library/Developer/CommandLineTools/Library/Developer/Frameworks",
                ]),
            ],
            linkerSettings: [
                .unsafeFlags([
                    "-L", "../build/swift-test",
                    "-lWhoami",
                    "-F", "/Library/Developer/CommandLineTools/Library/Developer/Frameworks",
                    "-Xlinker", "-rpath", "-Xlinker", "/Library/Developer/CommandLineTools/Library/Developer/Frameworks",
                    "-Xlinker", "-rpath", "-Xlinker", "/Library/Developer/CommandLineTools/Library/Developer/usr/lib",
                ]),
            ]
        ),
    ]
)

