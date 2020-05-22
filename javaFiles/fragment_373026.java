Element dataTag = doc.getDocumentElement();
Element peopleTag =  (Element) dataTag.getElementsByTagName("people").item(0);

Element newPerson = doc.createElement("person");

Element firstName = doc.createElement("firstName");
firstName.setTextContent("Tom");

Element lastName = doc.createElement("lastName");
lastName.setTextContent("Hanks");

newPerson.appendChild(firstName);
newPerson.appendChild(lastName);

peopleTag.appendChild(newPerson);