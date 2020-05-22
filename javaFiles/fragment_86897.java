public class Dice {
   public int sumOfNumDieRolls (int num) { 
      int sum = 0;
      for (int i=0;   i<num;   ++i) {
         int roll = (int) (6. * Math.random()) + 1;
         sum += roll;
      }
      return sum;
   }
}

@RunWith(PowerMockRunner.class)
@PrepareForTest( {Dice.class} )
public class DiceTest {
   @Test
   public void shouldAddUpDieRollsCorrectly() {
      PowerMock.mockStaticPartial(Math.class, "random");
      EasyMock.expect (Math.random()).andReturn(0.3334).anyTimes();
      Dice die = new Dice();
      PowerMock.replay(Math.class);
      assertEquals (12, die.sumOfNumDieRolls(4));
      assertEquals (30, die.sumOfNumDieRolls(10));
      PowerMock.verify(Math.class);
   }
}