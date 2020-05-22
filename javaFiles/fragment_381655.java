1. Take a string variable in your servlet.
 2. Put appropriate html string as per your conditions in this string variable
 3. send this string as a response from servlet like:

response.setCharacterEncoding("UTF-8");

response.getWriter().write("your string variable here"); 

 4. In your ajax call do like this:

    success : function(dataString) {
                document.getElementById("containerId").innerHTML=dataString;
    },