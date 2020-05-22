int number1 = 1;
int number2 = 2;
String myMessage = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
  + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
  + "  <soap:Body>"
  + "    <Add xmlns=\"http://tempuri.org/\">"
  + "      <intA>" + number1 + "</intA>"
  + "      <intB>" + number2 + "</intB>"
  + "    </Add>"
  + "  </soap:Body>"
  + "</soap:Envelope>";