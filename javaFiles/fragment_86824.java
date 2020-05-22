ecdhHandShake() {
    let _this = this;

    this.keyGeneration()
    .then( k => {
        ajax({
            url: "http://localhost:5050/test/ecdh/handshake",
            headers: {
                "Content-Type": "application/json"
            },
            body: {
                publickey: this.buf2Hex(this.publicKey)
            },
            method: 'POST',
            crossDomain: true,
            responseType: 'json'
        })
        .subscribe(
            payload => {
                const publicKey = _this.hex2Arr(payload.response.publicKey);
                _this.serverPublicKey = _this.hex2Arr(payload.response.publicKey);

                _this.importServerKey()
                .then(sharedSecret => {
                    const sharedSecretHex = this.buf2Hex(sharedSecret);
                    console.log("shared key: "+ sharedSecretHex);
                })
                .catch( e => {
                    console.log(e);
                })
            },
            error => {
                console.log(error);
            },
            () => console.log('done')
        )
        ;
    })
    .catch( e => {
        console.log(e);
    })
    ;
}


keyGeneration() {       

    let _this = this;
    return window.crypto.subtle.generateKey(
        {
            name: "ECDH",
            namedCurve: "P-256", // the curve name
        },
        true, // <== Here if you want it to be exportable !!
        ["deriveKey", "deriveBits"] // usage
    )
    .then(key => {
        _this.keys = key;
        return window.crypto.subtle.exportKey(
            "raw", //can be "jwk" (public or private), "raw" (public only), "spki" (public only), or "pkcs8" (private only)
            _this.keys.publicKey
        )
        .then(rawPublicKey => {
            _this.publicKey = rawPublicKey;
            return rawPublicKey;
        })
        .catch(function(err){
            console.error(err);
        })
        ;
    })
    .catch(function(err){
        console.error(err);
    })
    ;

}

importServerKey() {

    return window.crypto.subtle.importKey(
        'raw',
        this.serverPublicKey,
        {
            name: 'ECDH',
            namedCurve: 'P-256'
        },
        true,
        []
    )
    .then(aliceKeyImported => {
        return window.crypto.subtle.deriveBits(
            {
                name: 'ECDH',
                namedCurve: 'P-256',
                public: aliceKeyImported
            },
            this.keys.privateKey,
            256)
    })
    .catch( e => {
        console.log(e);
    })
}


hex2Arr( str ) {
    if (!str) {
        return new Uint8Array();
    }
    const arr = [];
    for (let i = 0, len = str.length; i < len; i+=2) {
        arr.push(parseInt(str.substr(i, 2), 16));
    }
    return new Uint8Array(arr);
}

buf2Hex( buf ) {
    return Array.from(new Uint8Array(buf))
        .map(x => ('00' + x.toString(16)).slice(-2))
        .join('')
}