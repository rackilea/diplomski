{
    "$schema": "http://json-schema.org/draft-03/hyper-schema",
    "additionalProperties": false,
    "id": "device:v1",
    "name": "device",
    "properties": {
        "components": {
            "$ref": "spec.json",
            "type": "object",
            },
        "usage": {
            "$ref": "spec.json",
            "type": "object",
            }
    }
},
"required": true,
"title": "Device",
"type": "object"
}