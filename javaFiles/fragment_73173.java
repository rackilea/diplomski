public Quaternion multiply(Quaternion q) {
        float rx = q.getX(), ry = q.getY(), rz = q.getZ(), rw = q.getW();

        float cx = x; // cx = current X
        float cy = y;
        float cz = z;
        float cw = w;

        this.w = cw*rw - cx*rx - cy*ry - cz*rz;
        this.x = cw*rx + cx*rw + cy*rz - cz*ry;
        this.y = cw*ry - cx*rz + cy*rw + cz*rx;
        this.z = cw*rz + cx*ry - cy*rx + cz*rw;
        return this;
    }