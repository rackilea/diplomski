By filter =By.xpath("MYLOCATOR");
        System.out.println("About to click on result");
        Point point = ad.findElement(filter).getLocation();
        int elementCenterX = point.getX() + 80;
        int elementCenterY = point.getY() + 100;
        System.out.println("value of x = "+elementCenterX+"   value of y = "+elementCenterY);
        ad.tap(2, elementCenterX , elementCenterY , 0);