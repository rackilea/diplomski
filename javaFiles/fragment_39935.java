.allowElements(
   new ElementPolicy() {
     public String apply(String elementName, List<String> attrs) {
       // Make sure that all links open in new windows/tabs without
       // using <base target> which also affects unsanitized links.
       attrs.add("target");
       attrs.add("_blank");
       return elementName;
     }
   }, "a")
.allowAttributes("href").matching(
   new AttributePolicy() {
     public String apply(String elementName, String attributeName, String value) {
       // Collect all link URLs.
       urls.add(value);
       return value;
     }
   }).onElements("a")