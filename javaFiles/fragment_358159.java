return signer.sign({
    key: pvt_key,
    passphrase: PASSPHRASE_KEY
    },
    'hex' // Note this use of 'hex'...
);