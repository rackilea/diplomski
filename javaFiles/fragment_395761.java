<select onchange="ListCities()" id="ListCountries">
<%
    String CountryId,CountryName;
    for(int k=0;k<= jsonarray.length()-1;k++ )
    {
        CountryId = jsonarray.getJSONObject(k).get("id").toString();
        CountryName = jsonarray.getJSONObject(k).get("name").toString();

        if (CountryId.equals(request.getParameter("CountryId")))
        {
            out.print("<option value=" + CountryId +" selected>" +CountryName+ "</option>");
        } else 
        {
            out.print("<option value=" + CountryId +">" +CountryName+ "</option>");
        }           
     }      
%>
</select>