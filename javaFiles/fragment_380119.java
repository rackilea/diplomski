public static Vehical createVehical(String line){
        String[] parts = line.split(",");
        String type = parts[parts.length -1]; //get the last column
        switch (type) {
                    case "Van":
                        return new Car(a, b, c,...);
                    case "Sedan":
                        return new Van(a, b, c...);
                    default:
                        return null;
                }
    }