while((values=validation.readLine())!=null) {
        valuesArray=values.split(",");
        if(valuesArray[2].equals("SchoolofCommunication")) {
            school = "SOC";
            break;
        }

        // this else branch is not reachable based on the contents of the file
        else if(valuesArray[2].equals("SchoolofEngineering")) {
            school = "SOE";
            break;
        }

    }