{
    "oneOf" : [{
            "$ref" : "/post_request_schema#"
        }, {
            "allOf" : [{
                    "$ref" : "/patch_request_schema#"
                }, {
                    "required" : ["id"]
                }
            ]
        }
    ]
}