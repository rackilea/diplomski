import org.apache.commons.beanutils.Converter;

class MyDateConverter implements Converter {
    @Override
    public Object convert(Class clazz, Object value) {
        if (clazz.equals(Date.class)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                return sdf.parse((String) value);
            } catch (ParseException pe) {
                throw new IllegalArgumentException(pe);
            } catch (ClassCastException cce) {
                throw new IllegalArgumentException(cce);
            }
        } else {
            throw new IllegalArgumentException("Expected Date class");
        }
    }
}

......

import org.apache.commons.beanutils.ConvertUtils;

@Test
public void testXmlRules() throws Exception {
    ConvertUtils.register(new MyDateConverter(), Date.class);
    Digester digester = DigesterLoader.createDigester(new InputSource(this
            .getClass().getResourceAsStream("rules.xml")));
    Person person = (Person) digester.parse(this.getClass()
            .getResourceAsStream("person.xml"));
    Assert.assertEquals("Joe Dirt", person.getName());
    Assert.assertEquals("123-45-6789", person.getSsn());
    Assert.assertEquals(new SimpleDateFormat("dd/MM/yyyy")
            .parse("07/04/1981"), person.getDob());
}