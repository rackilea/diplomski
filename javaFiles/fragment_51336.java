class Vet {
   private Bird bird; 
   public Vet(Bird bird) {
      this.bird = bird;
   }

   public void perfromCheckup() {
      bird.talk();
      bird.poop();
   }
}