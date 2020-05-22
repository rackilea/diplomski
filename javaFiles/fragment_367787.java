db.collection.aggregate([
  {
    $project: {
      revenueHeader: {
        $objectToArray: "$revenueHeader"
      }
    }
  },
  {
    $unwind: "$revenueHeader"
  },
  {
    $group: {
      _id: "$revenueHeader.k",
      total: {
        $sum: "$revenueHeader.v"
      }
    }
  }
])