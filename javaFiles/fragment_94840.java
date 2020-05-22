import java.lang.reflect.*

class Person {

  @Deprecated
  String name

}

def me = new Person(name:'dave')

assert me.name == 'dave'
assert me.'name' == 'dave'
assert me.getName() == 'dave'

assert Person.class.getDeclaredField('name') instanceof Field
assert Person.class.getDeclaredField('name').getAnnotations()
assert Person.class.getDeclaredField('name').getAnnotation(Deprecated.class)