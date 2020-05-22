const crypto = require('crypto');

const makeHash = (data) => {
  const hash = crypto.createHash('sha256');
  return hash.update(data, 'utf8');
}

const password = "password";
const salt = "mail@gmail.com";

const result = makeHash(password)
  .update(makeHash(salt).digest())
  .digest('base64')

console.log(result);