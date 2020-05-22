function onSubmit(){    

    var items = $("#jsGrid").jsGrid("option", "data");//$("#jsGrid") must match <div id="jsGrid"></div>
    var json = JSON.stringify(items);
    document.form1.json.value=json;
}

<form name="form1"  method="post" action="MyJavaBackend">
<div id="jsGrid"></div>
<input type="hidden" name="json"  >
<Input type="button" onClick="onSubmit();">
</form>