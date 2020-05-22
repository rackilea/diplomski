JavascriptExecutor js = (JavascriptExecutor)getDriver();

        ArrayList<Map<String, List<String> >> myList = new ArrayList<>();

        //Execute GTM script to fetch values       
        myList =  (ArrayList) js.executeScript("return window.dataLayer");

        // Parse through GTM arrayList  
        for(int a=0; a < myList.size(); a++) {
            for (String key : myList.get(a).keySet()) {
                System.out.println(key + "      " + myList.get(a).get(key));

            }
        }

         //Next Step
         // assert against expected values