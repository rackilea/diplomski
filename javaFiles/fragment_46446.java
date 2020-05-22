<form id="myForm" action="servletUrlPattern" method="post">
    <input name="chkUnmatch"
        type="checkbox"
        onclick="if (this.checked==true){chgFlag(true)}">Check Box
    <input type="submit"/>
</form>
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript">
 function chgFlag(isChecked){
     console.log('isChecked: '+isChecked);
     $.post( $('#myForm').attr('action'), { valueToChange : isChecked }).done(function( data ) {
            alert( "Data Loaded: " + data );
      });
 }
</script>