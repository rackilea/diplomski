Selenium selenium = new DefaultSelenium(host, port, browser, baseurl);

selenium.get(urlPath);

selenium.type(username_field, username);
selenium.type(password_field, password);
selenium.click(login_button);