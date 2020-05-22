Response resp1 =
        given().
            contentType(ContentType.URLENC).
            body("AUTH_TOKEN=&j_username=" + encodedUsername + "&j_password=" + password + "&userName=&AUTH_TOKEN=").
            redirects().follow(false).
        expect().
            statusCode(302).
        when().
            post("/authenticate/j_spring_security_check");

String headerLocationValue = resp1.getHeader("Location");

Response resp2 =
        given().
            cookie(resp1.getDetailedCookie("JSESSIONID")).
        expect().
            statusCode(200).
        when().
            get(headerLocationValue);