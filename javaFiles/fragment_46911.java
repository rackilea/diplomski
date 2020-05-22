public interface IGeometry {
    void accept(IGeometryVisitor visitor);
}

public interface IGeometryVisitor {
    void visitCircle2D(Circle2D circle);
    void visitBox2D(Box2D box);
    // a method for each concrete type
}

public class Circle2D implements IGeometry {
    public void accept(IGeometryVisitor visitor) {
        visitor.visitCircle2D(this);
    }
}

public class Box2D implements IGeometry {
    public void accept(IGeometryVisitor visitor) {
        visitor.visitBox2D(this);
    }
}

public class IntersectionVisitor implements IGeometryVisitor {
    private boolean mResult;
    private IGeometry mGeometry2;

    public static boolean isOverlapping(IGeometry geometry1, IGeometry geometry2) {
        return new IntersectionVisitor(geometry1, geometry2).mResult;
    }

    private IntersectionVisitor(IGeometry geometry1, IGeometry geometry2) {
        mGeometry2 = geometry2;
        // now start the process
        mGeometry1.accept(this);
    }

    public void visitCircle2D(Circle2D circle) {
        mGeometry2.accept(new Circle2DIntersector(circle));
    }

    private class Circle2DIntersector implements IGeometryVisitor {
        private Circle2D mCircle;
        Circle2DIntersector(Circle2D circle) {
            mCircle = circle;
        }
        public void visitCircle2D(Circle2D circle) {
            mResult = isOverlapping(mCircle, circle);
        }
        public void visitBox2D(Box2D box) {
            mResult = isOverlapping(mCircle, box);
        }
    }

    private class Box2DIntersector implements IGeometryVisitor {
        private Box2D mBox;
        Box2DIntersector(Box2D box) {
            mBox = box;
        }
        public void visitCircle2D(Circle2D circle) {
            mResult = isOverlapping(circle, mBox);
        }
        public void visitBox2D(Box2D box) {
            mResult = isOverlapping(mBox, box);
        }
    }

    // static methods to compute overlap of concrete types
    // For N concrete types there will be N*(N+1)/2 methods
    public static boolean isOverlapping(Circle2D circle1, Circle2D circle2) {
        return /* intersection of 2 circles */;
    }

    public static boolean isOverlapping(Circle2D circle, Box2D box) {
        return . . .;
    }

    public static boolean isOverlapping(Box2D box1, Box2D box2) {
        return . . .;
    }
}