//----- method to add data into database
        public void AddExerData(String newEntry){
// this db variable you are using! is not initialised!
            boolean insertData = db.addexerData(newEntry);
            if(insertData){
                toastMessage("Data Successfully Inserted");
            }else{
                toastMessage("Something went wrong");
            }

        }