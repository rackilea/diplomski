[
    { "$sort": { "TaxiLicence": 1, "GetOff": 1 } },
    { "$group": {
        "_id": "$TaxiLicence",
       "GetOff": { "$last": "$GetOff" },
       "GetOffLongitude": { "$last": "$GetOffLongitude" }
    }}
]