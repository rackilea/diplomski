{"namespace": "Schema",
  "name":"PvMap",
  "type":"record",
  "fields":[
  {"name": "TradeId", "type": "int"},
    { "name": "Tmap",
      "type":{
      "type":"map",
      "values":"float"}
      }
  ]
}