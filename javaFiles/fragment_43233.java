for (Inventory p : array)
    System.out.println(p);  // This prints every item in the list once

for(Inventory total: array) // And this is looping and printing again!
                            // This empty line does not matter, line below is looped
    System.out.printf("The total of the Inventory is:$%.2f ", total.getTotal());