CookingPot {
    void addPasta(Pantry pantry) {
        Pasta p = pantry.getPasta();
        System.out.println("Added " + p.toString() + " to the pot!"); 
        //fancy actions that use up some of the Pasta
        pantry.add(p); //return the pasta
    }
}

Pantry {
    Pasta getPasta(); //we have no idea what this does in actuality
}


@Test(expected = NullPointerException.class)
public void testAddPastaButNoPastaLeft() {
    Pantry mockPantry = mock(Pantry.class);

    CookingPot cookingPot = new CookingPot();
    cookingPot.addPasta(mockPantry);
    //we should probably have checked if there was pasta before 
    //attempting to add imaginary pasta
}

@Test
public void testAddPasta() {
    Pantry mockPantry = mock(Pantry.class);
    when(mockPantry.getBaz()).thenReturn(new Pasta());

    CookingPot cookingPot = new CookingPot();
    cookingPot.addPasta(mockPantry);
}