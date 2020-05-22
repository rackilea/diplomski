<script>
  var newInput4=document.createElement("input");
  newInput4.className="form-control ";
  newInput4.name="totalunit1";
  newInput4.placeholder="Unit";   
  newInput4.type="text";
  var formId = document.getElementById('formInput');
  newInput4.appendChild(formId);

</script>

<form method="GET" id="formInput" action="application/servletname"> //
<input type="submit" name="submit" value="submit">
</form>

//Serveletname.Java
String id = request.getParameter("totalunit1");