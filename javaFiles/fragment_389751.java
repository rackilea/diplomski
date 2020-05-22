public void addPhoneHistory(PhoneHistory phoneHistory){
         phoneHistory.setPhone(this); //This is importtant as its sets the parent
         if(this.phoneHistories == null){
            this.phoneHistories = new ArrayList<PhoneHistory>();
         } 
         this.phoneHistories.add(phoneHistory); 
      }