public void amuseAnimals( List<Animal> animals ) {
    for ( Animal animal : animals ) {
         if ( animal instanceof Dog ) {
             Dog doggy = (Dog)animal;
             doggy.takeForWalk( new WalkingRoute() );
         } else if ( animal instanceof Cat ) {
             Cat puss = (Cat)animal;
             puss.play( new BirdShapedToy() );
         }
     }
}