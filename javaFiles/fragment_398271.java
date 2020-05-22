while (keepGoing && k<2) {
        i++;
        j--;
        k++;
        keepGoing = i<j;  //explicitely recalculate value of keepGoing
    }