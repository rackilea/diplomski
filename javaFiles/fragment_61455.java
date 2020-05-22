/*! 
* Author: flohall
* date: 2019-11-05
* file: module/textEncryptor.js
*/
var CryptoJS = require("crypto-js");
var config = require('../config.json');
//keySize and iteration like specified in spring for AesBytesEncryptor
const keySize = 256;
const iterations = 1024;
//see config.json
const salt = CryptoJS.enc.Hex.parse(config.textEncryptor.hexEncodedSalt);
const secretKey = config.textEncryptor.secretKey;
const key = CryptoJS.PBKDF2(secretKey, salt, {
    keySize: keySize / 32,
    iterations: iterations
});

//same as NULL_IV_GENERATOR of AesBytesEncryptor - so encryption creates always same cipher text for same input
const iv = {words: [0, 0, 0, 0, 0, 0, 0, 0], sigBytes: 0}
const cfg = {
    iv: iv,
    padding: CryptoJS.pad.Pkcs7,
    mode: CryptoJS.mode.CBC
}

exports.encrypt = function (msg) {

    const encrypted = CryptoJS.AES.encrypt(msg, key, cfg);
    return encrypted.ciphertext.toString();
}

exports.decrypt = function (encryptedMessage) {

    var encrypted = { ciphertext: CryptoJS.enc.Hex.parse(encryptedMessage)};
    var decrypted = CryptoJS.AES.decrypt(encrypted, key, cfg)
    return decrypted.toString(CryptoJS.enc.Utf8);

}