public static class LogPeriodic extends LevenbergMarquardt {
        public final double tc;
        public double A,B,C1,C2,w,m,o;
        public double[] best = new double[3];
        public double[] info;

        public LogPeriodic(int threads, double tc) {
            super(threads);
            this.tc = tc;
        }

        public double value(double t, double... parameters) {
            m = parameters[0];
            w = parameters[1];

            // solve the linear parameters
            double[] ABCC = getABCC(tc, m, w);
            A = ABCC[0];
            B = ABCC[1];
            C1 = ABCC[2];
            C2 = ABCC[3];

            double a=pow((tc - t),m);
            return A + B * a + C1 * a * cos(w * log(tc - t)) + C2 * a * sin(w * log(tc - t)); 
        }

        @Override
        public void setValues(double[] parameters, double[] values) {
            int j=0;
            for (int i=start;i<N;i++) {
                double t = decimalYear(T[i]);
                double a=pow((tc - t),m);
                values[j++] = value(decimalYear(T[i]), parameters);
            }
        }

    }