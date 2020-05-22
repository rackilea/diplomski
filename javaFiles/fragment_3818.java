// based on http://www.java3d.org/starting.html
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.vecmath.*;

public class Demo
{
  public Demo() {
    SimpleUniverse universe = new SimpleUniverse();
    BranchGroup group = new BranchGroup();
    group.addChild(createModel());
    universe.getViewingPlatform().setNominalViewingTransform();
    universe.addBranchGraph(group);
  }

  Node createModel() {
    double radius = 0.3;
    ColorCube cube = new ColorCube(radius);
    // rotation of cube about the center of the top face
    // i.e. the point (x=0, y=radius, z=0)
    Transform3D transform = new Transform3D();
    // step 1: translate cube down so that (0, radius, 0) is at the origin
    Transform3D translate1 = new Transform3D();
    translate1.setTranslation(new Vector3d(0.0, -radius, 0.0));
    transform.mul(translate1, transform);
    // step 2: rotate cube about X axis by 180 degrees
    Transform3D rotate = new Transform3D();
    rotate.rotX(Math.PI);
    transform.mul(rotate, transform);
    // step 3: translate cube back up
    Transform3D translate2 = new Transform3D();
    translate2.setTranslation(new Vector3d(0.0, +radius, 0.0));
    transform.mul(translate2, transform);
    // create a TransformGroup
    TransformGroup tg = new TransformGroup();
    tg.setTransform(transform);
    tg.addChild(cube);
    return tg;
  }

  public static void main(String[] args) {
    new Demo();
  }
}