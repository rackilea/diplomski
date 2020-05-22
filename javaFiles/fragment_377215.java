//It will match all the product name based on the xpath (index alone needs to be removed from your index)
      List<WebElement> element = driver.findElements(By.xpath("(//td[@data-id='product_name'])"));

        int size=element.size();

        for(int i=0;i<size;i++){
            productsInOrder.add(element.get(i).getText()); 
        }