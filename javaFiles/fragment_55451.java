public void TravelCard(double balance, String expiry){
        sdf.setLenient(false);
        this.balance = balance;
         try {
             this.expirationDate = sdf.parse(expiry);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }