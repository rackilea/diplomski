for (int i = 0; i < getArrayOne().length; i++) {        
    System.out.print(getArrayOne()[i] + " ");
    if(i < getArrayTwo().length) { // check that i is within bounds of ArrayTwo
        System.out.print(getArrayTwo()[i] + " ");
    }
}