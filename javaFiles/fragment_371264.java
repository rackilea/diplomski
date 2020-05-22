{
  "type": "object",
  "required": [ "id" ],
  "properties": {
     "id": {
        "type": "string",
        "description": "The node id"
     },
     "children": {
        "type": "array",
        "items": { "$ref": "#" }
     }
  }
}