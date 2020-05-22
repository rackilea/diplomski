from Crypto.Cipher import PKCS1_OAEP
rsa_key = RSA.generate(2048)
cipher = PKCS1_OAEP.new(rsa_key)
pubkey = rsa_key.publickey()
data = {'key' : base64.b64encode(pubkey.exportKey(format='DER'))}
resp = requests.post('http://localhost:9000/crypt/', data=data)
decoded = cipher.decrypt(base64.b64decode(resp.text))