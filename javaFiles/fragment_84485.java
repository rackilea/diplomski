{
    "total": 1,                          // maps to primitive, integer
    "movies": [                          // '[' marks the beginning of an array/collection
        {                                // '{' marks the beginning of an object
            "id": "770672122",           // maps to primitive, string
            "title": "Toy Story 3",
            "year": 2010,
            "mpaa_rating": "G",
            "runtime": 103,
            "release_dates": {          // each array object also contains another object
                "theater": "2010-06-18",
                "dvd": "2010-11-02"
            }
        }
    ]
}