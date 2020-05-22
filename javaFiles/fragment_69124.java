wait = new WebDriverWait(driver, 20);
                By container = By.xpath(".//*[@id='webForm:sensorContainer']/div/div[1]/div[1]/div/div[6]");
                wait.until(ExpectedConditions.visibilityOfElementLocated(container));

                /* Read the text that appears in the XPath text control. */
                WebElement ajaxControl = driver.findElement(container);
                String ajaxTextFirstPara = ajaxControl.getText().trim();

                WebElement ele= driver.findElement(container);
                try{
                       wait.until(ExpectedConditions.stalenessOf(ele));
                }catch(TimeoutException e){
                }

                /* Wait for the new content to appear in the xpath text control. */
                By newAjaxcontrol =  container;
                Wait<WebDriver> newwait = new FluentWait<>(driver)
                        .withTimeout(60, TimeUnit.SECONDS)
                        .pollingEvery(5, TimeUnit.SECONDS)
                        .ignoring(NoSuchElementException.class);
                newwait.until(ExpectedConditions
                        .visibilityOfElementLocated(newAjaxcontrol));
                WebElement undergroundTemperature_14_L_value= driver.findElement(newAjaxcontrol);
                String undergroundTemperature_14_L =undergroundTemperature_14_L_value.getText().trim();
                if(ajaxTextFirstPara!= undergroundTemperature_14_L)
                {
                    System.out.println("diffeerent");
                }else{
                    System.out.println("same");
                }