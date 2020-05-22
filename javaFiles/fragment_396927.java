//initialize first
markbook[openSpot] = new Mark(name, totalMark, mark, weight);

//use later
for(int i = 0; i < markbook.length; i++) {
        if(markbook[i].getAssignment(name) == null) {   // java.lang.NullPointerException is thrown here
            openSpot = i;
            break;
        }

    }