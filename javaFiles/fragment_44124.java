boolean loginSuccess = false;

    Header[] locationHeader = response.getHeaders("Location");
    if (locationHeader.length > 0) {
            if (response.getStatusLine().toString().contains("302") && locationHeader[0].toString().endsWith(requestURL)) {
                loginSuccess=true;
            }
    }
    System.out.println("Login Success: " + loginSuccess);