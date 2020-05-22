testNames = OOJavaBasics.TEST_NAMES;
     String resultString="";
        for (int i = 0; i < testNames.length; i++) {
            if (thirdLastLine.contains("OK (0 tests)") && testNames[i].equals("wanted result")){ // do not compare an Array with an int in the .equals()
                resultString += "E";
            }
        }
System.out.println(resultString);