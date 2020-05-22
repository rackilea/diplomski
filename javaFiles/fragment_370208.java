public final class Ref {
    public final static int LicenseCode = 800;
    public final class Widget {
        public final static int MaxWeight = 5000;
        public final class MolyBolt {
            public final static int ThreadsPerInch = 12;
        }
    }
    public static void main(String[] args) {
        int v = Integer.valueOf(args[0]);
        switch (v) {
            case Ref.LicenseCode:
                break;
            case Ref.Widget.MaxWeight:
                break;
            case Ref.Widget.MolyBolt.ThreadsPerInch:
                break;
        }
    }
}