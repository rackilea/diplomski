$("#loginForm").submit(function(evt)
{
    evt.preventDefault();

    if (loginFormInputIsValid ())
    {
       $.ajax ({
                type: "POST",
                url: "/login",
                data: $(this).serialize(),
                success: function (response)
                {
                   window.location = response;
                }
         });
    }
}