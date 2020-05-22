{
    "query": {
        "bool": {
            "must": [{
                    "geo_distance": {
                        "distance": "1000000km",
                        "location": {
                            "lat": 24.46667,
                            "lon": 118.1
                        }
                    }
                },
                {
                    "term": {
                        "type": {
                            "value": 1
                        }
                    }
                }
            ]
        }
    },
    "sort": {
        "_geo_distance": {
            "location": "24.46667,118.1",
            "order": "asc"
        }
    }
}