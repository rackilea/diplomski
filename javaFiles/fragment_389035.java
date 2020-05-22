while((values=validation.readLine())!=null) {
        valuesArray=values.split(",");
        if(valuesArray[0].equals(id) && valuesArray[2].equals("SchoolofCommunication")) {
            school = "SOC";
            break;
        } else if((valuesArray[0].equals(id) && valuesArray[2].equals("SchoolofEngineering")) {
            school = "SOE";
            break;
        }
    }