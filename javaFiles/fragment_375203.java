public static float[] getFilledArcVertexes(float x, float y, float r, double startingAngleDeg, double endAngleDeg, int slices) {
        if(startingAngleDeg < 0)
            Heatstroke.error("Starting angle cannot be smaller than 0");
        if(endAngleDeg >= 720)
            Heatstroke.error("End angle cannot be greater or equal to than 720");
        if(endAngleDeg < startingAngleDeg)
            Heatstroke.error("End angle cannot be smaller than starting angle");
        int radius = (int) r;

        double arcAngleLength = (endAngleDeg - startingAngleDeg) / 360f;

        float[] vertexes = new float[slices*6+6];

        double initAngle = Math.PI / 180f * startingAngleDeg;
        float prevXA = (float) Math.sin(initAngle) * radius;
        float prevYA = (float) Math.cos(initAngle) * radius;

        for(int arcIndex = 0; arcIndex < slices+1; arcIndex++) {
            double angle = Math.PI * 2 * ((float)arcIndex) / ((float)slices);
            angle += Math.PI / 180f;
            angle *= arcAngleLength;
            int index = arcIndex * 6;
            float xa = (float) Math.sin(angle) * radius;
            float ya = (float) Math.cos(angle) * radius;
            vertexes[index] = x;
            vertexes[index+1] = y;
            vertexes[index+2] = x+prevXA;
            vertexes[index+3] = y+prevYA;
            vertexes[index+4] = x+xa;
            vertexes[index+5] = y+ya;
            prevXA = xa;
            prevYA = ya;
        }

        return vertexes;
    }