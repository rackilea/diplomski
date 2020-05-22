List list = fillUpArray(scan);
        System.out.println(list.get(0));
        while(i+1<list.size()){
            mileage=(((FillUp)list.get(i+1)).getOdometer()-((FillUp) list.get(i)).getOdometer())/((FillUp) list.get(i+1)).getGallons();
            System.out.println("Mileage: "+mileage);
            i++;
        }