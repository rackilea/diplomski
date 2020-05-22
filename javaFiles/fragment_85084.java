for(int j=0; j<op.length; j++){
            if(make.equals("Ford"))
                cars[i] = new Ford(model,year);
            else if(make.equals("Mazda"))
                cars[i] = new Mazda(model,year,colour);
            else if(make.equals("Toyota"))
                cars[i] = new Toyota(model,year,h);

        }