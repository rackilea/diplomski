"title": {
            "type": "multi_field",
            "fields": {
                "title": {"type": "string", "index": "analyzed"},
                "exact": {"type": "string","index": "not_analyzed"}
            }
        }