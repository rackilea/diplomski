void test() {
            while (true) {
                int aNumber;
                try {
                    aNumber = Integer.parseInt(br.readLine());
                    System.out.println("Hurray you enterd a number! It is " + aNumber + ".");
                    return;
                } catch (NumberFormatException | IOException e) {
                    System.out.println("Error: Something went wrong. Please try again.\n");

                }
            }
        }