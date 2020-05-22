interface Planet  {
public void orbit();
}
class PlanetMain  {
private Planet p = new Planet () {
    public void orbit() {
        System.out.println("interface Planet class executed");
   }
 };
}