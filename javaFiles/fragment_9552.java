private ArrayList DeSerializeArrayList(string serializedData) {
  ArrayList list = new ArrayList();
  Type[] extraTypes = new Type[1];
  extraTypes[0] = typeof(MyBusinessObject);
  System.Xml.Serialization.XmlSerializer serializer = new System.Xml.Serialization.XmlSerializer(typeof(ArrayList), extraTypes);
  XmlReader xReader = XmlReader.Create(new StringReader(serializedData));
  try {
    Object obj = serializer.Deserialize(xReader);
    list = (ArrayList)obj;
  } catch { throw; } finally {
    xReader.Close();
  }
return list; 
}