public void setGender(String gender) {
       if (!"male".equalsIgnoreCase(gender) && !"female".equalsIgnoreCase(gender)) {
           throw new IllegalArgumentException("Bad parameter");
       }
       /* TODO: Implement */ 
    }