POST /{yourIndex}/{yourType}/_search
{
    "aggs" : {
        "company_count" : {
            "cardinality" : {
                "field" : "company.company_raw",
                "precision_threshold": 10000
            }
        }
    }
}