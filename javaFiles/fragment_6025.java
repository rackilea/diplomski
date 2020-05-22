<%

 final String welshName = (String) request.getAttribute("welshName");
 final String englishName = (String) request.getAttribute("englishName");
 final String gender = (String) request.getAttribute("gender");

 %>

 Welsh Name: <input type="text" name="welshName" class="inputBox" value="<% out.print(welshName); %>"/>
 English Name: <input type="text" name="englishName" class="inputBox" value="<% out.print(englishName); %>"/>

 Gender:
 <select name="gender" class="dropDown">
     <option value="Masculine" <% out.print("masculine".equals(gender) ? "selected" : ""); %>>Masculine</option>
     <option value="Feminine" <% out.print("feminine".equals(gender) ? "selected" : ""); %>>Feminine</option>
 </select>