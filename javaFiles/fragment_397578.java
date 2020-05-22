{
  ...
  "definitions": {
    ...
    "stdItem": {
      "type": "object",
      "required" : ["stdItem"],
      "properties": {
        "stdItem": {
          "type": "object",
          "required" : ["stdAttributes"],
          "properties": {
            "stdType": { ... },
            "stdAttributes": { ... },
            "children": { ... }
          }
        }
      }
    }
  },
  ...
}