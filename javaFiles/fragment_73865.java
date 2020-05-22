try {
            dr.findElement(By.xpath(xpath); // find element with whatever Selector, I am using xpath
            if (dr.findElementsByXPath(xpath).size()>0 && dr.findElement(By.xpath(xpath)).isDisplayed()){
                System.out.println("Element found by xpath : " + xpath);
                return true;
            } else
                return false;
        } catch (NoSuchElementException e1) {
            System.out.println("Object not found");
            return false;
        } catch (Exception e2) {
            System.out.println("Unhandled Exception found");
            e2.printStackTrace();
            throw e2;
        }