public class MoveEye extends Applet
{
    public MoveEye()
    {
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas = new Canvas3D(config);
        add("Center", canvas);

        BranchGroup content = getScene();
        content.compile();

        SimpleUniverse universe = new SimpleUniverse(canvas);
        Transform3D move = lookTowardsOriginFrom(new Point3d(0, 0, -3));
        universe.getViewingPlatform().getViewPlatformTransform().setTransform(move);
        universe.addBranchGraph(content);
    }

    public BranchGroup getScene()
    {
        BranchGroup group = new BranchGroup();

        group.addChild(new ColorCube(.5));

        return group;
    }

    public Transform3D lookTowardsOriginFrom(Point3d point)
    {
        Transform3D move = new Transform3D();
        Vector3d up = new Vector3d(point.x, point.y + 1, point.z);
        move.lookAt(point, new Point3d(0.0d, 0.0d, 0.0d), up);

        return move;
    }

    public static void main(String args[])
    {
        Frame frame = new MainFrame(new MoveEye(), 256, 256);
    }
}