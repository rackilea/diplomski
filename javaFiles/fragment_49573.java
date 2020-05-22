while (scanner.hasNext()) {
            // print what is scanned
            String currentValue = scanner.next();
            boolean isDouble = false;
            try {
                double doubleValue = Double.valueOf(currentValue);
                isDouble = true;
                System.out.println(doubleValue + " : " + isDouble);
            } catch(NumberFormatException ex) {
                System.out.println(currentValue + " : " + isDouble);
            }
            // check if the scanner's next token is a double
//          System.out.println("" + scanner.hasNextDouble());

        }