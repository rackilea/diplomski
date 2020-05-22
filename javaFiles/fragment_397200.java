JsonArrayBuilder jsonregistration= Json.createArrayBuilder();
while(rs.next())
{
    jsonregistration.add(rs.getString(1));
}
JsonArray jsonArray =  jsonregistration.build();