for(int j = 0; j < itemArrDB_FOIAExemptionOptions.length; j++) {
                    // getting each table row checkbox text and storing it in an array to compare
                    int xpathIndex=j+1;
                    String xpathLocation = "//*[@id='ctl00_ctl00_Content_ContentPlaceHolderMain_ctl00_EditControl_FouoExemptionCheckBox']/tbody/tr["+xpathIndex+"]/td/span/label";
                    expectedText = driver.findElement(By.xpath(xpathLocation)).getText().trim();
                    actualFOIAExemptions[j] = expectedText;
                    System.out.println("ADDED: " + actualFOIAExemptions[j]);

                }
                System.out.println("----------------------------------");
                System.out.println("itemArrDB_FOIAExemptionOptions = " + Arrays.toString(itemArrDB_FOIAExemptionOptions));
                System.out.println("actualFOIAExemptions = " + Arrays.toString(actualFOIAExemptions));
                System.out.println("----------------------------------");


                if(Arrays.equals(actualFOIAExemptions, itemArrDB_FOIAExemptionOptions)) {
                    System.out.println("matches the DB");
                    report.log(LogStatus.PASS, "matches the DB");
                }
                else {
                    System.out.println("DOES NOT match the DB");
                    report.log(LogStatus.FAIL, "s DOES NOT match the DB");
                }