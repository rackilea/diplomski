while(helperLeft <= middle && helperRight <= high) {
        if(helper.get(helperLeft).isLessThan( helper.get(helperRight))) {
            list.add(current, helper.get(helperLeft));
            helperLeft++;
        } else {
            list.add(current, helper.get(helperRight));
            helperRight++;
        }
        current++;
    }

    //Copy remaining elements
    int remaining = middle - helperLeft;
    for(int j=0; j <= remaining; j++) {
        list.add(current+j, helper.get(helperLeft+j));
    }