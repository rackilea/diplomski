public class Foo {
     @DatabaseField(generatedId = true)
     private int id;
     @DatabaseField // no default-value specified
     private Integer someIntegerField;
}
...
Foo foo = new Foo();
// leave someIntegerField as a null value without a default-value defined
assertEquals(1, dao.create(foo));

Foo result = dao.queryForId(foo.id);
assertNotNull(result);
// by default the field that we did not initialize comes back as null
assertNull(result.someIntegerField);