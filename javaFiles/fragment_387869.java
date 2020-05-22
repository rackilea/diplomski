### Serialize without unwrapped annotation ###
{
  "age" : 12,
  "name" : {
    "first" : "Tom",
    "last" : "Sawyer"
  }
}

### Deserialize with unwrapped annotation ###
Parent{age=13, name=Name{first='Huckleberry', last='Finn'}}