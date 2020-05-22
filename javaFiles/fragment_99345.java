public class DistanceUnit{
        public static final Converter METER = new MeterConverter();
        public static final Converter FOOT = new FootConverter();
    }


    public interface Converter{

        public double fromMetric(double d);

        public double toMetric(double d);       
    }

    public class MeterConverter implements Converter{

        @Override
        public double fromMetric(double d) {
            return d;
        }

        @Override
        public double toMetric(double d) {
            return d;
        }        
    }

    public class FootConverter implements Converter{

        @Override
        public double fromMetric(double meters) {
            return meters*3.28084;
        }

        @Override
        public double toMetric(double feet) {
            return feet*0.3048;
        }        
    }