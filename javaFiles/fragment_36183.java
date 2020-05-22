$("#loginBtn").click(function() { 
    var form = document.createElement("form");
    document.body.appendChild(form);
    $(form).append("<input type='hidden' name='username' value='"+$("#username").val()+"'>");
    $(form).append("<input type='hidden' name='password' value='"+$("#password").val()+"'>");
    form.action="http://localhost:8080/NewDesignV1/login.action";
    form.method="post";
    form.submit();
    $(form).remove();
});