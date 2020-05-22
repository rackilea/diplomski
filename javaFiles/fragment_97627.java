pipeline = [
    {
        "$match": {
            "_id": employeeId
        }
    },
    {
        "$lookup": {
            "from": "company", 
            "localField": "companyId",
            "foreignField": "_id",
            "as": "company"
        }
    },
    {
        "$project": {
            "name": 1,
            "lastName": 1,
            "companyId": 1,
            "companyName": "$company.companyName"
        }
    }
];
db.employee.aggregate(pipeline);