function sign(secret, message){

    var secretString = String.fromCharCode.apply(String, secret);
    var messageString = String.fromCharCode.apply(String, message);

    var hash = CryptoJS.HmacSHA256(messageString, secretString);
    return CryptoJS.enc.Base64.stringify(hash).replace(/\+/g, '-').replace(/\//g, '_').replace(/\=+$/, '');
}