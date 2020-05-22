function decrypt (messagebase64, keyBase64, ivBase64) {

    if(keyBase64.length<CIPHER_KEY_LEN){
        var padding = CIPHER_KEY_LEN-keyBase64.length;
        for(var i=0;i<padding;i++){
            keyBase64+="0";
        }
    }else if(keyBase64.length>CIPHER_KEY_LEN){
        keyBase64 =keyBase64.substring(0, CIPHER_KEY_LEN)
    }


    var key = Buffer.from(keyBase64, 'latin1');
    var iv = Buffer.from(ivBase64, 'base64');

    var encryptdata = new Buffer(messagebase64, 'base64');

    var decipher = crypto.createDecipheriv('aes-128-cbc', key, iv),
        decoded = decipher.update(encryptdata, 'base64', 'utf8');

    decoded += decipher.final('utf8');


    return decoded

}