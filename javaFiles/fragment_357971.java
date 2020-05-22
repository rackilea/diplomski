"country": {
            "type": "multi_field",
            "fields": {
                "country": {"type": "string", "index": "analyzed"},
                "exact": {"type": "string","index": "not_analyzed"}
            }
        }