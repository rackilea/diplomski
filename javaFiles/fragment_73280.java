org.jsoup.nodes.Document document = (org.jsoup.nodes.Document) Jsoup.connect("https://www.capitaliq.com/CIQDotNet/Login.aspx/authentication.php").userAgent("Mozilla/5.0")               
            .data("myLogin$myUsername", "MyUsername")
            .data("myLogin$myPassword, "MyPassword")
            .data("myLogin$myLoginButton.x", "22")                   
            .data("myLogin$myLoginButton.y", "8")
            .data("__VIEWSTATE", viewState)
            .data("__EVENTVALIDATION", eventValidation)
            .cookies(loginForm.cookies())
            .post();