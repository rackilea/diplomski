if (model.nr_class == 2) {
        System.out.println("Two classes "); 
        if (model.solverType.isSupportVectorRegression()) { 
            System.out.println("Support vector");
            return dec_values[0];
        }
        else { 
            System.out.println("Not Support vector");
            return dec_values[0]; 
        }    
    }