public class Test {
    static class Vector3 {
        public float x, y, z;

        public Vector3(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Vector3 add(Vector3 other) {
            return new Vector3(x + other.x, y + other.y, z + other.z);
        }

        public Vector3 sub(Vector3 other) {
            return new Vector3(x - other.x, y - other.y, z - other.z);
        }

        public Vector3 scale(float f) {
            return new Vector3(x * f, y * f, z * f);
        }

        public Vector3 cross(Vector3 other) {
            return new Vector3(y * other.z - z * other.y,
                               z - other.x - x * other.z,
                               x - other.y - y * other.x);
        }

        public float dot(Vector3 other) {
            return x * other.x + y * other.y + z * other.z;
        }
    }

    public static boolean intersectRayWithSquare(Vector3 R1, Vector3 R2,
                                                 Vector3 S1, Vector3 S2, Vector3 S3) {
        // 1.
        Vector3 dS21 = S2.sub(S1);
        Vector3 dS31 = S3.sub(S1);
        Vector3 n = dS21.cross(dS31);

        // 2.
        Vector3 dR = R1.sub(R2);

        float ndotdR = n.dot(dR);

        if (Math.abs(ndotdR) < 1e-6f) { // Choose your tolerance
            return false;
        }

        float t = -n.dot(R1.sub(S1)) / ndotdR;
        Vector3 M = R1.add(dR.scale(t));

        // 3.
        Vector3 dMS1 = M.sub(S1);
        float u = dMS1.dot(dS21);
        float v = dMS1.dot(dS31);

        // 4.
        return (u >= 0.0f && u <= dS21.dot(dS21)
             && v >= 0.0f && v <= dS31.dot(dS31));
    }

    public static void main(String... args) {
        Vector3 R1 = new Vector3(0.0f, 0.0f, -1.0f);
        Vector3 R2 = new Vector3(0.0f, 0.0f,  1.0f);

        Vector3 S1 = new Vector3(-1.0f, 1.0f, 0.0f);
        Vector3 S2 = new Vector3( 1.0f, 1.0f, 0.0f);
        Vector3 S3 = new Vector3(-1.0f,-1.0f, 0.0f);

        boolean b = intersectRayWithSquare(R1, R2, S1, S2, S3);
        assert b;

        R1 = new Vector3(1.5f, 1.5f, -1.0f);
        R2 = new Vector3(1.5f, 1.5f,  1.0f);

        b = intersectRayWithSquare(R1, R2, S1, S2, S3);
        assert !b;
    }
}