[
    {
        "$match" :{
            "key" : "KEYCODE001"
        }
    }, 
    {
        "$unwind" :{
            "path" : "$values", "preserveNullAndEmptyArrays" : true
        }
    }, 
    {
        "$unwind" :{
            "path" : "$values.objects", "preserveNullAndEmptyArrays" : true
        }
    }, 
    {
        "$match" :{
            "values.classId" : "CLASS_01"
        }
    }, 
    {
        "$project" :{
            "classId" : "$values.classId", "object" : "$values.objects"
        }
    }, 
    {
        "$group" :{
            "_id" : "$classId",
            "objects" :{
                "$push" : "$object"
            }
        }
    }, 
    {
        "$project" :{
            "classId" : "$_id", "objects" : 1
        }
    }
]