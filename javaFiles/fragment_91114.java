<% 
    if(request.getRequestURL().toString().equals("https://old.example.com")){    
        String redirectURL = "https://new.example.com"; 
        response.sendRedirect(redirectURL);
    }
%>