> db.test.find({key_strengths:"Hard Working"}).explain()
{
        "cursor" : "BtreeCursor key_strengths_1",
        "isMultiKey" : true,
        "n" : 2,
        "nscannedObjects" : 2,
        "nscanned" : 2,
        ...
        "indexBounds" : {
                "key_strengths" : [
                        [
                                "Hard Working",
                                "Hard Working"
                        ]
                ]
        },
        ...

}
>