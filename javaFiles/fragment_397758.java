for(int i = 1;  i <= datafile.getAnzahlRessources(); i++){

        for(int j = 0 ; j < makroperiodencount; j++){

            PriosSort = datafile.sortPriosAtPeriodAtRessource(j,i);
            System.out.println("");
            for(ProductRessource m : PriosSort){
                periode = j + 1;
                System.out.println("Key: " + m.getKey() + " für Makroperiode: " + periode + " Prio: " + m.getPrioAtPeriode(j));
            }               
        }

        }