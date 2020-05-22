driver.get("https://www.google.co.uk/");
        org.openqa.selenium.JavascriptExecutor js;
        if (driver instanceof org.openqa.selenium.JavascriptExecutor) {
            js = (org.openqa.selenium.JavascriptExecutor)driver;
        }
        else {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }

        js.executeScript("window.open('http://www.seleniumhq.org');");