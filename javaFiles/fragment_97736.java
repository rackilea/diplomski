public static void simpleArray(String[] greetings) {

              String str = "Welcome To CWU BANK!", "Thank you for using CWU ATM!", "Please insert DEBIT card", "We value your business!";

              int i = (int)(Math.random() * greetings.length);
              System.out.println(greetings[i]);
              }
          }