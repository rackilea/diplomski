@TupleConstructor(includes=['name'])
class Counter {
  @Id String id
  String name
  long count = 0
  Date createdTimestamp = new Date()
  Date updatedTimestamp = new Date()
}