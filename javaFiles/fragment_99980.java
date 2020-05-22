import java.awt.GraphicsConfiguration;
import java.util.ArrayList;
import java.util.List;

import javax.media.j3d.Alpha;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.RotPosPathInterpolator;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3d;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class RotPosPathInterpolatorTest
{
    public static void main(String[] args) 
    {
        System.setProperty("sun.awt.noerasebackground", "true");

        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;

        GraphicsConfiguration config = 
            SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas = new Canvas3D(config);
        frame.getContentPane().add(canvas);
        SimpleUniverse simpleUniverse = new SimpleUniverse(canvas);

        BranchGroup rootBranchGroup = new BranchGroup();
        createContents(rootBranchGroup);

        simpleUniverse.addBranchGraph(rootBranchGroup);

        Transform3D t0 = new Transform3D();
        t0.rotX(Math.toRadians(-45));
        Transform3D t1 = new Transform3D();
        t1.setTranslation(new Vector3d(0,0,10));
        t0.mul(t1);
        simpleUniverse.
            getViewingPlatform().
            getViewPlatformTransform().
            setTransform(t0);

        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class InterpolatorData
    {
        private final List<Point3f> positions = new ArrayList<Point3f>();
        private final List<Quat4f> orientations = new ArrayList<Quat4f>();

        void add(Point3f p, float angleDeg)
        {
            positions.add(p);

            AxisAngle4f a = new AxisAngle4f(
                0.0f, 1.0f, 0.0f, (float) Math.toRadians(angleDeg));
            Quat4f q = new Quat4f();
            q.set(a);
            orientations.add(q);
        }

        Point3f[] getPositions()
        {
            return positions.toArray(new Point3f[0]);
        }

        Quat4f[] getOrientations()
        {
            return orientations.toArray(new Quat4f[0]);
        }

        float[] getAlphas()
        {
            float alphas[] = new float[positions.size()];
            float delta = 1.0f / (alphas.length - 1);
            for (int i=0; i<alphas.length; i++)
            {
                alphas[i] = i * delta;
            }
            return alphas;
        }
    }

    private static void createContents(BranchGroup rootBranchGroup)
    {
        Alpha alpha = new Alpha(-1, Alpha.INCREASING_ENABLE, 
            0, 0, 6000, 0, 0, 0, 0, 0);
        TransformGroup target = new TransformGroup();
        target.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        Transform3D axisOfTransform = new Transform3D();

        InterpolatorData i = new InterpolatorData();
        i.add(new Point3f(-2.0f, 0.0f,  2.0f),   0.0f);
        i.add(new Point3f(-2.0f, 0.0f, -2.0f),   0.0f);
        i.add(new Point3f(-2.0f, 0.0f, -2.0f),  90.0f);
        i.add(new Point3f( 2.0f, 0.0f, -2.0f),  90.0f);
        i.add(new Point3f( 2.0f, 0.0f, -2.0f), 180.0f);
        i.add(new Point3f( 2.0f, 0.0f,  2.0f), 180.0f);
        i.add(new Point3f( 2.0f, 0.0f,  2.0f), 270.0f);
        i.add(new Point3f(-2.0f, 0.0f,  2.0f), 270.0f);
        i.add(new Point3f(-2.0f, 0.0f,  2.0f),   0.0f);

        RotPosPathInterpolator interpolator = new RotPosPathInterpolator(
            alpha, target, axisOfTransform, 
            i.getAlphas(), i.getOrientations(), i.getPositions());        
        interpolator.setSchedulingBounds(
            new BoundingSphere(new Point3d(), 100.0));

        rootBranchGroup.addChild(target);
        target.addChild(interpolator);
        target.addChild(new ColorCube(0.4));
    }
}