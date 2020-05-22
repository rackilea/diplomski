public boolean is_touched(float xx,float yy) {
            float x = position.x;
            float y = position.y;
            return (xx - x) * (xx - x) + (yy - y) * (yy - y) < radius * radius;
        }
    }