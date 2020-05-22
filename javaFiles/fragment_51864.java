const low = require('lowdb')
const FileSync = require('lowdb/adapters/FileSync')

const adapter = new FileSync('./products.json')
const db = low(adapter)

console.log(db.get('product').find({"productid": "1222"}).value())