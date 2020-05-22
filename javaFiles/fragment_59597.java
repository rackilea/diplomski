extension Data {
    struct HexEncodingOptions: OptionSet {
        let rawValue: Int
        static let upperCase = HexEncodingOptions(rawValue: 1 << 0)
    }

    func hexEncodedString(options: HexEncodingOptions = []) -> String {
        let format = options.contains(.upperCase) ? "%02hhX" : "%02hhx"
        return map { String(format: format, $0) }.joined()
    }
}

func generateRandomDoubleBufferHexString(count: Int, randomParameters: (min: Double, max: Double, percision: Int) = (0.0, 1.0, 100000)) -> String {

    func generateRandomDouble(min: Double = 0.0, max: Double = 1.0, percision: Int = 100000) -> Double {
        let scale: Double = Double(Int(arc4random())%percision)/Double(percision)
        return min + (max-min)*scale
    }

    var doubleArray: [Double] = [Double]() // Create empty array
    // Fill array with random values
    for _ in 0..<count {
        doubleArray.append(generateRandomDouble(min: randomParameters.min, max: randomParameters.max, percision: randomParameters.percision))
    }

    // Convert to data:
    let data: Data = doubleArray.withUnsafeBufferPointer { Data(buffer: $0) }

    // Convert to hex string
    return data.hexEncodedString()
}