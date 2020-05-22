function encrypt(plainText, keyBase64, ivBase64) {

    if(keyBase64.length<CIPHER_KEY_LEN){
        var padding = CIPHER_KEY_LEN-keyBase64.length;
        for(var i=0;i<padding;i++){
            keyBase64+="0";
        }
    }else if(keyBase64.length>CIPHER_KEY_LEN){
        keyBase64 =keyBase64.substring(0, CIPHER_KEY_LEN)
    }

    var key = Buffer.from(keyBase64, 'latin1');
    var iv = Buffer.from(ivBase64,'latin1');
    var encoded_base64_iv= iv.toString('base64');

    var cipher2 = crypto.createCipheriv('aes-128-cbc', key, iv);
    cipher2.write(plainText);
    cipher2.end();

    var cipher_text = cipher2.read();
    var encodedString = cipher_text.toString('base64');

    var final_encrypted_data = encodedString+":"+encoded_base64_iv;

    return final_encrypted_data.toString();
};