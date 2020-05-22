@AllArgsConstructor
class CustomObject {

   @Wither @Getter
   private final int state;

}

CustomObject one = new CustomObject(1);
CustomObject two = one.withState(2);

assertThat(one.getState(),equalTo(1));
assertThat(two.getState(),equalTo(2));