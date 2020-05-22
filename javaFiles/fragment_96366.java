db.sample.aggregate([
  { "$match": {
    "show.season.episodes.metaTags": "Arya Stark"
  }},
  { "$unwind": "$show" },
  { "$unwind": "$show.season" },
  { "$unwind": "$show.season.episodes" },
  { "$unwind": "$show.season.episodes.metaTags" },
  { "$group": {
    "_id": {
      "_id": "$_id",
      "show": {
        "name": "$show.name",
        "season": {
          "_id": "$show.season._id",
          "episodes": {
            "_id": "$show.season.episodes._id",
          }
        }
      }
    },
    "metaTags": { "$push": "$show.season.episodes.metaTags" },
    "matched": {
      "$sum": {
        "$cond": [
          { "$eq": [ "$show.season.episodes.metaTags", "Arya Stark" ] },
          1,
          0              
        ]
      }
    }
  }},
  { "$sort": { "_id._id": 1, "_id.show.season.episodes._id": 1 } },
  { "$group": {
    "_id": {
      "_id": "$_id._id",
      "show": {
        "name": "$_id.show.name",
        "season": {
          "_id": "$_id.show.season._id",
        },
      }
    },
    "episodes": {
      "$push": {
        "$cond": [
          { "$gt": [ "$matched", 0 ] },
          {
            "_id": "$_id.show.season.episodes._id",
            "metaTags": "$metaTags"
          },
          false
        ]             
      }
    }
  }},
  { "$unwind": "$episodes" },
  { "$match": { "episodes": { "$ne": false } } },
  { "$group": {
    "_id": "$_id",
    "episodes": { "$push": "$episodes" }
  }},
  { "$sort": { "_id._id": 1, "_id.show.season._id": 1 } },
  { "$group": {
    "_id": {
      "_id": "$_id._id",
      "show": {
        "name": "$_id.show.name"
      }
    },
    "season": {
      "$push": {
        "_id": "$_id.show.season._id",
        "episodes": "$episodes"
      }
    }
  }},
  { "$group": {
    "_id": "$_id._id",
    "show": {
      "$push": {
        "name": "$_id.show.name",
        "season": "$season"
      }
    }
  }}
])