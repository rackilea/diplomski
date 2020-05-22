public void verifyEachCommonAcronymsAndAbbreviationsForAPB(String itemLocatorP1, String itemLocatorP2, String txtFromDB) {
        String[] txt = new String[3];
        boolean compareValue1 = false, compareValue2 = false;
        WebElement abbreviation = driver.findElement(By.xpath(itemLocatorP1));
        WebElement fullName = driver.findElement(By.xpath(itemLocatorP2));
        String p1, p2;

        if((abbreviation.isDisplayed()) && (fullName.isDisplayed())) {
            try {
                getMenu().scroll_To_View_Web_Element(itemLocatorP1);
                p1 = getUITxt(itemLocatorP1);
                getMenu().scroll_To_View_Web_Element(itemLocatorP2);
                p2 = getUITxt(itemLocatorP2);
                txt[0] = p1;
                txt[1] = p2;
            }
            catch(Exception e) {
                txt[0] = "Blank";
                System.out.println("Array txt Exception-> " + txt[0]);
            }
            // removing some html txt from the txtFromDB so that it can match with the UI
            txtFromDB = txtFromDB.replaceAll("<dt>", "");
            txtFromDB = txtFromDB.replaceAll("</dt>", "");
            txtFromDB = txtFromDB.replaceAll("<dd>", "");
            txtFromDB = txtFromDB.replaceAll("</dd>", "");
            txtFromDB = txtFromDB.replaceAll(">", "");
            txtFromDB = txtFromDB.replaceAll("</dl>", "");
            txtFromDB = txtFromDB.replaceAll("</dl", "");
            txtFromDB = txtFromDB.replaceAll("<dl style=", "");
            txtFromDB = txtFromDB.replaceAll("float: left; text-align: left; width: 50%;", "");
            txtFromDB = txtFromDB.replaceAll("\"\"", "");
            txtFromDB = txtFromDB.replaceAll("&nbsp;", " ");
            txtFromDB = txtFromDB.replaceAll("amp;", "");
            txtFromDB = txtFromDB.replaceAll("&nbsp;", " ");
            txtFromDB = txtFromDB.replaceAll("&rsquo;s", "’s");
            txtFromDB = txtFromDB.replaceAll("&ndash;", "–");
            txtFromDB = txtFromDB.replaceAll("(?m)^[ \t]*\r?\n", "");
            //System.out.println("DB Txt -> " + txtFromDB);

            String[] splitArrDB = txtFromDB.split("\\n");

            List<String> acronymsList = new ArrayList<>();

            for(int i = 0 ; i < splitArrDB.length; i++) {
                acronymsList.add(splitArrDB[i] + splitArrDB[i]);
            }


            for(String temp : acronymsList) {
                if((temp.contains(txt[0]))) {
                    System.out.println("Found " + txt[0] + " in the list");
                    compareValue1 = true;
                    break;
                }
                //System.out.println("still searching.....");
            }

            for(String x : acronymsList) {
                if((x.contains(txt[1]))) {
                    System.out.println("Found " + txt[1] + " in the list");
                    compareValue1 = true;
                    break;
                }
                //System.out.println("still searching.....");
            }