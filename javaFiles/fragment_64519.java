$match:{},
 $redact: {
                "$cond": [{
                        "$gt": ["$firstfield", "$secondfiled"}]
                    },
                     "$$KEEP", "$$PRUNE"
                ]
            }