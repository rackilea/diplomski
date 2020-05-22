String input = "ContactPerson.BusinessPartner.name1,ContactPerson.BusinessPartner.name2,ContactPerson.fullname";
String[] parts = input.split(",");
for (String part : parts) {
    String[] subparts = part.split("\\.");
    String last = subparts[subparts.length - 1];
}