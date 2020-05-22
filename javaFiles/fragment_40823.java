{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties" : {
    "address": {
      "type" : "object",
      "anyOf" : [
        { 
          "properties" : {
            "house_number" : {
              "type":"string",
              "maxLength": 4
            },
          },
          "required":["house_number"]
        },
        { 
          properties : {
            "house_name" : {
              "type" : "string",
                "maxLength" : 50
            }
          },
          "required":["house_name"]
        }
      ]
    }
  },
  required: ["address"],
  examples : [
    {
      baddress: {
      }
    },
    {
      address: {
        "house_number":"1234",
        "house_name" : null
      }
    },
    {
      address: {
        "house_number":null,
        "house_name" : null
      }
    },
    {
      address: {
        "house_number":null,
        "house_name" : "some name"
      }
    },
    {
      address: {
        "house_number": "12345",
        "house_name" : "some afafafasagagagffgfsagragsgasgasssssssfdgsdfgsdfgdsgsdfgsdgsdfgdfsgsdfgs name"
      }
    },
  ]
}