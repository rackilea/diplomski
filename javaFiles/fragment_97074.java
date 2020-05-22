"dynamic_templates": [
          {
            "id_as_keywords": {
              "match_mapping_type": "string",
              "match_pattern": "regex",
              "match": ".*(id|Id|Ids)",
              "mapping": {
                "type": "keyword"
              }
            }
          }
        ]