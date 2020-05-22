else if (whatToDo.equalsIgnoreCase("Alchemy") || whatToDo.equalsIgnoreCase("7")) {
        try {
        Alchemy.startAlchemy();
        } catch(Exception e) {
           System.out.println("The problem is not with else if but the exception");
           e.printStackTrace();
        }
    }