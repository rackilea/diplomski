Stream<Executable> executables = 
keyNames.stream()
        .map(key-> 
               // create an executable for each value of the streamed list
                ()-> {
                        String expectedValue = getExpectedValue(line, key);
                        String elementName = mappingProperties.getProperty(key.toString());

                        if (elementName != null && elementName.contains(HEADER)){
                             assumingThat((expectedValue != null && expectedValue.length() > 0),
                                            () -> {                                             
                                                    String actualValue = testHelper.getHeaderData(searchResult, elementName);
                                                    if(expectedValue != null) {
                                                        assertEquals(expectedValue, actualValue, " ###Element Name -> " + elementName +" :  Excepted Value ### " + expectedValue + " ### Actual Value ###" + actualValue);
                                                    }                                                                            

                                            }
                            );

                        }

                    }
            );
Assertions.assertAll(executables);