pipeline = [
    {
        "$match": {
            "store_data.store_uuid": {
                "$in": [
                    "15a6cc90-081f-11e5-b213-001e6745ff8d",
                    "217b983b-5904-11e4-a1f0-00163ed23ec2",
                    "5337d78d-5904-11e4-a1f0-00163ed23ec2"
                ]
            },
            "product_related_data.product_uuid": "f44aa29d-09ce-4902-bf12-d45d44b3dfd0"
        }
    },
    { "$sort": { "time.check_date": -1 } },
    {
        "$group": {
            "_id": "$sensostrip_data.barcode",
            "stock_percentage": { "$first": "$stock_related_data.stock_percentage" },
            "store_uuid": { "$first": "$store_data.store_uuid" },
            "check_date": { "$first": "$time.check_date" }
        }
    },
    { "$limit": 100 }
];
db.readings.aggregate(pipeline);