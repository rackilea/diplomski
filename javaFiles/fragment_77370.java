"parser": {
    "type" : "map",
    "parseSpec": {
      "format": "timeAndDims",
      "dimensionsSpec": {
        "dimensions": [
          "dim1",
          "dim2",
          "dim3"
        ]
      },
      "timestampSpec": {
        "format": "auto",
        "column": "ts"
      }
    }
  }