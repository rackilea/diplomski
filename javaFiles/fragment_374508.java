Table A        Table B
-------        -------
id | name      a_id | status

class Foo
{
    private int id;
    private string name;
    private string status;
}

<class name="Foo">
  <id name="id"/>
  <property name="name"/>
  <join table="B">
    <key column="a_id"/>
    <property name="status"/>
  </join>
</class>