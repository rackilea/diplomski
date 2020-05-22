do{
        try{
            message = (String) input.readObject();
            showMessage("\nClient"+clientName+": got replay " + message+ " for query " +queryNum);

        }catch(ClassNotFoundException classNotFoundException){
            showMessage("Unknown data received!");
        }
        finally{
            waitForReplay.release();
        }
    }while(true);