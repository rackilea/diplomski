ArrayList<Double> list = new ArrayList();
        // get and remove weight
        Double weight = list.get(0);
        list.remove(0);
        // sum and find min
        double min=Double.MAX_VALUE;
        double sum=0;
        for (Double d : list) {
            if (d<min) min = d;
            sum+=d;
        }
        // subtract min value from sum
        sum-=min;
        // apply weight
        sum*=weight;
        // calc weighted avg
        double avg = sum/list.size()-1;
        // viola!