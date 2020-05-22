function addIpSubmit() 
{                 
    var theForm = document.getElementById("login_form");
    var userName = theForm.username.value;
    userName = theForm.clientip.value + "#" + userName;
    theForm.j_username.value = userName;
    if( validate_required( theForm.username, "User ID is required" ) )
    {
        if(  validate_required( theForm.j_password, "Password is required" ) )
        {
            theForm.submit();
        }
    }
}  

function validate_required( field, alerttxt )
{
    with (field)
    {
        if (value==null||value=="")
        {
            alert(alerttxt);
            return false;
        }
        else
        {
            return true;
        }
    }
}