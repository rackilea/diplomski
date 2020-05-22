function generateHashCode(text)
{
    // assuming text is UTF-8 encoded

    var crypto = require('crypto');
    var hexDigest = crypto.createHash('SHA1').update(text).digest(); // this should be .digest() not .digest('hex')

    var hexStr = "";
    for (var i = 0; i < hexDigest.length; i++) {
        hexStr += (((hexDigest[i] - 0x100) & 0xff) + 0x100).toString(16).substr(1); // fixed some math issues here
    }

    var hashid = 0;
    var a = 'a'.charCodeAt(0); // or just var a = 97;
    for (var i = 0; i < hexStr.length; i++)
        hashid += Math.abs(Math.pow(27, 10 - i) * (a - (1 + hexStr.charCodeAt(i))));

    return hashid;
}

console.log(generateHashCode("batman"));