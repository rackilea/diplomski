while (cursor.getNext(theKey, theData, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
            foundKey = new String(theKey.getData(), "UTF-8");
            foundData = new String(theData.getData(), "UTF-8");
                // this is to see each key - data - inputdata as I was having an issue
            System.out.println("KEY: " + foundKey + 
                    "\nDATA: " + foundData +
                    "\nINPUT_DATA: " + dataInput + "\n\n");

            if (foundData.equals(dataInput)) {
                System.out.println("-----------------------------------\n\n");
                System.out.println("Found record: " + foundKey +
                            "\nwith data: " + foundData);
                System.out.println("\n\n-----------------------------------");
            }
            // THIS IS THE FIX 
            theKey = new DatabaseEntry();
            theData = new DatabaseEntry();
            // ----------------------------

        }