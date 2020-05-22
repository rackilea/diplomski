Boolean exist;
    if(exist = driver.findElements(By.className("page-title")).size() == 0){
        WebElement errorMessage = driver.findElement(By.className("error-msg"));

        if(errorMessage.getText().contains("Invalid login or passwords.")){
            System.out.println("Test passed but login failed.");
        }
        else
            System.out.println("error-msg class found but different message in it.");
    }

    else{
        WebElement dashboardTitle = driver.findElement(By.className("page-title"));
        if(dashboardTitle.getText().contains("Account Information"))
            System.out.println("Logged in successfully.");
        else
            System.out.println("LOGGED IN");
    }