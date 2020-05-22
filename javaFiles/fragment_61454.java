exports.decrypt = function (encryptedMessage) {

    var encrypted = { ciphertext: CryptoJS.enc.Hex.parse(encryptedMessage)};
    var decrypted = CryptoJS.AES.decrypt(encrypted, key, cfg)
    return decrypted.toString(CryptoJS.enc.Utf8);

}