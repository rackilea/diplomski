{
    ...

    "aggregations" : {
        "genders" : {
            "buckets" : [
                {
                    "key" : "male",
                    "doc_count" : 10,
                    "tag_top_hits":{"hits":...}
                },
                {
                    "key" : "female",
                    "doc_count" : 10,
                    "tag_top_hits":{"hits":...}
                },
            ]
        }
    }
}