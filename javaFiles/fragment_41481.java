"mappings": {
    "roadType": {
        "properties": {
        }
    },
    "carType": {
        "_parent": {
            "type": "roadType"
        },
        "properties": {
            "make": {
                "type": "string"
            },
            "model": {
                "type": "string"
            }
        }
    }
}