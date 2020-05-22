// This method will accept any number of titles
 public void waitUntilTextChanges(WebDriver driver, String... titles) {

         new FluentWait<WebDriver>(driver)
        .withTimeout(60, TimeUnit.SECONDS)
        .pollingEvery(10, TimeUnit.MILLISECONDS)
        .until(new Predicate<WebDriver>() {

            public boolean apply(WebDriver d) {
                boolean titleMatched = false;
                // Get current window title
                String windowTitle = driver.getTitle();
                for(String title : titles){
                   // Iterate through all input titles and compare with window title 
                   titleMatched = windowTitle.equalsIgnoreCase(title);
                   // If match found, exit 
                   if(titleMatched){
                      break;
                   }
                }    
                return titleMatched;
            }
        });
    }