ArrayList<whatever> temp = new ArrayList<whatever>();
for(int j=0; j<Screens.columns; j++){//for loop of seats in row
    System.out.println("Please enter 'o' for a seat or press enter for a space");
    in = scanInValue.next();
    temp.add(j, in);//seats in a row arraylist
}
DataArrays2.getCinemaRowLayout2().add(i, tmp);