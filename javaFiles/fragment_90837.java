let keyData: NSData = Base64.decode(secret_key) as NSData
        let cData = param_signature


        let hmacResult: String = cData.hmac(algorithm: HMACAlgorithm.SHA1, key: keyData)


enum HMACAlgorithm {
    case MD5, SHA1, SHA224, SHA256, SHA384, SHA512

    func toCCHmacAlgorithm() -> CCHmacAlgorithm {
        var result: Int = 0
        switch self {
        case .MD5:
            result = kCCHmacAlgMD5
        case .SHA1:
            result = kCCHmacAlgSHA1
        case .SHA224:
            result = kCCHmacAlgSHA224
        case .SHA256:
            result = kCCHmacAlgSHA256
        case .SHA384:
            result = kCCHmacAlgSHA384
        case .SHA512:
            result = kCCHmacAlgSHA512
        }
        return CCHmacAlgorithm(result)
    }

    func digestLength() -> Int {
        var result: CInt = 0
        switch self {
        case .MD5:
            result = CC_MD5_DIGEST_LENGTH
        case .SHA1:
            result = CC_SHA1_DIGEST_LENGTH
        case .SHA224:
            result = CC_SHA224_DIGEST_LENGTH
        case .SHA256:
            result = CC_SHA256_DIGEST_LENGTH
        case .SHA384:
            result = CC_SHA384_DIGEST_LENGTH
        case .SHA512:
            result = CC_SHA512_DIGEST_LENGTH
        }
        return Int(result)
    }
}

extension String {
    func hmac(algorithm: HMACAlgorithm, key: NSData) -> String {
        let cKey = key
        let cData = self.cString(using: String.Encoding.ascii)
        var cHMAC = [CC_SHA1_DIGEST_LENGTH]
        CCHmac(algorithm.toCCHmacAlgorithm(), cKey.bytes, cKey.length, cData, Int(strlen(cData!)), &cHMAC)
        let hmacData:NSData = NSData(bytes: cHMAC, length: (Int(algorithm.digestLength())))
        let hmacBase64 = hmacData.base64EncodedString(options: NSData.Base64EncodingOptions(rawValue: 0))
        return String(hmacBase64)
    }
}