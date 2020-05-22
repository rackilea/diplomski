### Create order [POST]

Create a new order

+ Request Post new order (application/json)

    + Attributes (object)
        + customIds (object)
            + id: `12345` (string, optional) - The order custom id
            + system: `Some` (enum[string], optional) - The order custom id's system name
                + Members
                    + `Some1`
                    + `Some2`
                    + `Some3`
        + customerName: `John` (string, required) - The customer's given name
    + Body

            {
                "customerName" : "John", 
                "customIds": [{"system": "some", "id": "123"}] //optional
            }