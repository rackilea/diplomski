private string SerializeArrayList(ArrayList obj) { 
  System.Xml.XmlDocument doc = new XmlDocument();
  Type[] extraTypes = new Type[1];
  extraTypes[0] = typeof(MyBusinessObject);
  System.Xml.Serialization.XmlSerializer serializer = new System.Xml.Serialization.XmlSerializer(typeof(ArrayList), extraTypes); 
  System.IO.MemoryStream stream = new System.IO.MemoryStream(); 
  try { 
    serializer.Serialize(stream, obj); 
    stream.Position = 0; 
    doc.Load(stream); 
    return doc.InnerXml; 
  } catch { throw; } finally { 
    stream.Close(); 
    stream.Dispose(); 
  } 
}