String textToSelect;
            List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));

            for (WebElement option : optionsToSelect) {
                textToSelect="";
                List<WebElement> textPerLi= option .findElements(By.tagName("span"));

                  textToSelect=textToSelect+textPerLi.get(0).getText();

                if ("Text you want to match with".equals(textToSelect)) {
                    System.out.println("Trying to select: " + textToSelect);
                    option.click();
                    break;
                }
            }