public class Static3DWorld extends JFrame {
    private Transform3D rotate1 = new Transform3D();
    private Transform3D rotate2 = new Transform3D();
    ....
    private Transform3D rotateCube() {
      rotate1.rotX(Math.PI / 4.0d);
      rotate2.rotY(Math.PI / 4.0d);
      rotate1.mul(rotate2);
      return rotate1;
    }
    ....
}