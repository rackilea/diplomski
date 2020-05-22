Serializer ser = new Persister(new AnnotationStrategy());

final String xml = "<Tournaments>\n"
        + "   <Category category_id=\"289\">\n"
        + "      <Tournament>aaaa</Tournament>\n"
        + "   </Category>\n"
        + "   <Category category_id=\"32\">\n"
        + "      <Tournament>bbbd</Tournament>\n"
        + "      <Tournament>cccc</Tournament>\n"
        + "   </Category>\n"
        + "</Tournaments>";

Tournaments t = ser.read(Tournaments.class, xml);

System.out.println(t);