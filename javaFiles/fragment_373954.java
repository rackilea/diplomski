public Food eat(Food x) throws Exception
    {
        if (x.equals(new Plant("Meat"))) {
                throw new Exception("Herbivores only eat plants!");
            } else {
                return x;
            }    
    }