"function_score": {
    "query": {
        "term": {
            "title": "long"
        }
    },
    "functions": [
        {
            "filter": {
                "term": {
                    "title": "long"
                }
            },
            "script_score": {
                "script": "_score*2.0*doc['val_a6'].value"
            }
        }
    ],
    "score_mode": "max",
    "boost_mode": "replace"
}