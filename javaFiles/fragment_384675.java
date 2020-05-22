app.get('/autologin', function(request, response) {
    let token = request.headers['Authorization'];
    var isValid = false;
    // Your check logic here
    if(isValid){// If Valid redirect to SiteB
        response.cookie('id_token' ,request.headers['x-auth-token'], { maxAge: 9000,expires: 600}); 
        response.redirect(301,'http://www.siteB.com');
    }else{//If not Valid redirect back to SiteA


        return response.redirect(301, "http://www.siteA.com"); 
    }
});