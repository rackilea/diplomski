public class Human implements Copyable<Human> {

   @Override
   public Human copy(Human t) {
       return    Human.builder()
                     .name(human.getName())
                     .age(human.getAge())
                     .build();
   }

}