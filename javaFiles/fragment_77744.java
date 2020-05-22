const parentNode = TronWallet.fromMnemonic('all all all all all all all all all all all all')
    const node = parentNode.derivePath("m/49'/195'/0'/0/0")
    const latestBlock = {
      hash: '000000000046b520515cd81609c969e5659568bf360859f7e5493ceedd6ec41d',
      number: 4633888,
      timestamp: 1543869858000
    }

    const tx = node.generateTransaction('TR2a3x6tX5trbhaTBU71Fpi1SWYj8gKEGy', 5000000, 'TRX', latestBlock)
    console.log(tx.hex)
    console.log(tx.txid)