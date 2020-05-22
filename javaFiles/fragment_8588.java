driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        HashMap<String, String> imageMap = new HashMap<String, String>();
        boolean isPresent = false;
        String actual = "";
        while(!isPresent){

            //System.out.println("body is "+body);
            String current = driver.findElement(By.id("ImagePlaceHolder")).getCssValue("background-image");
            if(!actual.equalsIgnoreCase(current)){
                WebElement body = driver.findElement(By.id("ImagePlaceHolder"));
                actual = current;
                if(imageMap.containsKey(actual))
                    isPresent = true;
                else{
                    imageMap.put(actual, new Date().toString());
                    System.out.println("Image : " + actual + " appeared at : " + new Date().toString());
                }
                current = body.getCssValue("background-image");
            }
        }