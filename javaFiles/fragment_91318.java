{ "version" : "1.0",
  "descriptors" : [ {
    "id" : "todo-representation",
    "descriptors" : [ {
      "name" : "description",
      "doc" : {
        "value" : "Details about the TODO item",
        "format" : "TEXT"
      },
      "type" : "SEMANTIC"
    }, {
      "name" : "title",
      "doc" : {
        "value" : "Title for the TODO item",
        "format" : "TEXT"
      },
      "type" : "SEMANTIC"
    }, {
      "name" : "id",
      "type" : "SEMANTIC"
    } ]
  }, {
    "id" : "get-todos",
    "name" : "todos",
    "type" : "SAFE",
    "rt" : "#todo-representation"
  }, {
    "id" : "create-todos",
    "name" : "todos",
    "type" : "UNSAFE",
    "rt" : "#todo-representation"
  }, {
    "id" : "delete-todo",
    "name" : "todo",
    "type" : "IDEMPOTENT",
    "rt" : "#todo-representation"
  }, {
    "id" : "patch-todo",
    "name" : "todo",
    "type" : "UNSAFE",
    "rt" : "#todo-representation"
  }, {
    "id" : "get-todo",
    "name" : "todo",
    "type" : "SAFE",
    "rt" : "#todo-representation"
  } ]
}