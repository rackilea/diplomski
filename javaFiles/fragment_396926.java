for(int i = 0; i < markbook.length; i++) {
        if(markbook[i].getAssignment(name) == null) {   // java.lang.NullPointerException is thrown here
            openSpot = i;
            break;
        }

    }
    markbook[openSpot] = new Mark(name, totalMark, mark, weight);//you are initializing markbook after and trying to use it before