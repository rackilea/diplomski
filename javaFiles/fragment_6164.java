class XmlString(str: String) {
  def assumeXML = xml.XML.loadString("<xml:group>" + str + "</xml:group>")
  def toUnparsedXML = new xml.Unparsed(str)
}
implicit def stringToXmlString(str: String) = new XmlString(str)

def value = "Hello <BR/> World"