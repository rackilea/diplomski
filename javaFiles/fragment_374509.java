Table Users         Table Companies
----------          -------------
id | name           id | trademark

Table Contacts
-----------------------
id | text | owner_id | owner_type

class User/Company implements HasContacts
{
    private int id;
    private string name/trademark;
    private Set<Contact> contacts;
}

class Contact
{
    private int id;
    private string text;
    private HasContacts owner;
}

<class name="Contact">
  <id name="id"/>
  <property name="name"/>
  <any name="owner" id-type="System.Int64" meta-type="System.String">
    <meta-value value="user" class="User"/>
    <meta-value value="company" class="Company"/>
    <column name="owner_id"/>
    <column name="owner_type"/>
  </any>
</class>

<class name="User">
  <id name="id"/>
  <property name="name"/>
  <set name="contacts" where="owner_type='user'">
    <key column="owner_id"/>
    <one-to-many class="Contact"/>
  </set>
</class>

<class name="Company">
  <id name="id"/>
  <property name="trademark"/>
  <set name="contacts" where="owner_type='company'">
    <key column="owner_id"/>
    <one-to-many class="Contact"/>
  </set>
</class>