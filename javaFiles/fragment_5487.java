FileReader xsd = new FileReader("customer.xsd");
XSDHelper.INSTANCE.define(xsd, null);

FileReader xml = new FileReader("input.xml");
XMLDocument doc = XMLHelper.INSTANCE.load(xml, null, null);

DataObject customerDO = doc.getRootObject();
int id = customerDO.getInt("id");
DataObject addressDO = customerDO.getDataObject("contact-info/address");