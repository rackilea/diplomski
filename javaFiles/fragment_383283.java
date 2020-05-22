db.mid.aggregate([{
        $unwind: "$hustle"
    }, {
        $group: {
            _id: "$hustle.id",
            name: {
                $first: "$hustle.name"
            },
            level: {
                $first: "$hustle.level"
            },
            recentTIme: {
                $first: "$hustle.completedTime"
            },
            accessCount: {
                $sum: 1
            }
        }
    }, {
        $out: "Recent_MID"
    }]).pretty()