if (numberbag < 24 && numberbag > 0) {
              System.out.println("no discount: $" + price);
           }
           else if (numberbag < 49 && numberbag > 25) {
              System.out.println("5% discount: $" + (price - (price * .05)));    
           }
           else if (numberbag < 99 && numberbag > 50) {
              System.out.println("10% discount: $" + (price - (price * .10)));    
           }
           else if (numberbag < 149 && numberbag > 100) {
              System.out.println("15% discount: $" + (price - (price * .15)));    
           }
           else if (numberbag < 199 && numberbag > 150) {
              System.out.println("20% discount: $" + (price - (price * .20)));    
           }
           else if (numberbag < 299 && numberbag > 200) {
              System.out.println("25% discount: $" + (price - (price * .25)));    
           }
           else {
              System.out.println("30% discount: $" + (price - (price * .30)));
           }