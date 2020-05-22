public class SomeTest {

    public void testRotate90(){
        CartesianPoint cp = new CartesianPoint(1,0);
        CartesianPoint cp2 = cp.rotate90();
        SUnit.assertEquals(0, cp2.getX());
        SUnit.assertEquals(1, cp2.getY());
   }
}