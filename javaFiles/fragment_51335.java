class Vet {
   private Animal animal; 
   public Vet(Animal animal) {
      this.animal = animal;
   }

   public void perfromCheckup() {
      animal.talk();
      animal.poop();
   }
}