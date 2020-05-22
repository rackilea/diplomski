for (String href : hrefs) {
            driver.navigate().to(href);
            boolean isPresent = driver.findElements(By.xpath("element")).size() > 0;
            if (isPresent) {
                String test = driver.findElement(By.xpath("element")).getText();
                System.out.println(test);
            } else {
                System.out.println("Name not found");
            }
            Thread.sleep(3000); // To check if the navigation is happening properly.
        }
    }
}