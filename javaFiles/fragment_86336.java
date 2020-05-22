private void displayItems(List<Double> items) {
        double current_item=0;
        for(int i=0; i<items.size(); i++) {
            int count=1;
            current_item = items.get(i);
            if(i != items.size()) {
                int j=i+1;
                for(; j<items.size(); j++) {
                    double next_item = items.get(j);
                    if(current_item == next_item) {
                        count++;
                    }else {
                        break;
                    }
                }
                System.out.println("item value is " + current_item + " and count is " + count);
                i = j-1;
            }
        }
    }