db.collection.find({
    "$or": [ 
        { "imageShared.rateMedia.rateVal1": { "$exists": true } }, 
        { "imageShared.rateMedia.rateVal2": { "$exists": true } }
    ] 
})