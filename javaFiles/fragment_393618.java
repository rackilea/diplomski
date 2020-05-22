extension String {
    func hmac(algorithm: kCCHmacAlgSHA1, key: NSData) -> String {
        let cKey = key
        let cData = self.cString(using: String.Encoding.ascii)
        var cHMAC = [CC_SHA1_DIGEST_LENGTH]
        CCHmac(CCHmacAlgorithm(kCCHmacAlgSHA1), cKey.bytes, cKey.length, cData, Int(strlen(cData!)), &cHMAC)
        let hmacData:NSData = NSData(bytes: cHMAC, length: cHMAC)
        let hmacBase64 = hmacData.base64EncodedString(options: NSData.Base64EncodingOptions(rawValue: 0))
        return String(hmacBase64)
    }
}

let hmacResult: String = cData.hmac(algorithm: HMACAlgorithm.SHA1, key: keyData)