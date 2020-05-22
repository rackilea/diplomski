class T(db.Model):
   prop = db.ListProperty(int)

print db.model_to_protobuf(T(prop=[1, 2, 3]))

# result:
key <
  app: "testapp"
  path <
    Element {
      type: "T"
      id: 0
    }
  >
>
entity_group <
>
property <
  name: "prop"
  value <
    int64Value: 1
  >
  multiple: true
>
property <
  name: "prop"
  value <
    int64Value: 2
  >
  multiple: true
>
property <
  name: "prop"
  value <
    int64Value: 3
  >
  multiple: true
>