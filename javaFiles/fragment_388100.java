function stateChanged()
{
    if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
    {
        var showdata = xmlHttp.responseText;
        var strar = showdata.split(":");

        if(strar.length==1)
        {
            document.getElementById("locName").focus();
            alert("Please Select location Id");
        }
        else if(strar.length>1)
        {
            option=new Option("---Select---", -1);

            document.crtdocfrm.ddDeptName.options[0]=option;
            for(var i=1;i<strar.length-1;i=i+2)
            {
                option=new Option(strar[i+1], strar[i]);
                document.crtdocfrm.ddDeptName.options[(i-1)/2+1]=option;
            }
        }
    }
}