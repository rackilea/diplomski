const crypto = require('crypto');
const hexToUuid = require('hex-to-uuid');

const java_kind_hash = (input) => {
    var md5Bytes = crypto.createHash('md5').update(input).digest()
    md5Bytes[6] &= 0x0f;  // clear version 
    md5Bytes[6] |= 0x30;  // set to version 3 
    md5Bytes[8] &= 0x3f;  // clear variant 
    md5Bytes[8] |= 0x80;  // set to IETF variant
    return hexToUuid(md5Bytes.toString('hex'))
}

console.log('java_kind_hash ', java_kind_hash ("HelloWorld"));
    // 68e109f0-f40c-372a-95e0-5cc22786f8e6