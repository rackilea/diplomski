public class EnumExample {

    enum SwitchEnum {
        NORTH   ("North star"),
        EAST    ("Eastpack rulez!"),
        SOUTH   ("https://www.southafrica.net/"),
        WEST    ("java.awt.BorderLayout.WEST");

        private final String label;
        SwitchEnum(final String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return this.label;
        }

        private static final Map<String,SwitchEnum> map;
        static {
            map = new HashMap<String,SwitchEnum>();
            for (SwitchEnum v : SwitchEnum.values()) {
                map.put(v.label, v);
            }
        }
        public static SwitchEnum findByLabel(String label) {
            return map.get(label);
        }
    }

    public static String doEnumSwitch(String enumString) {
        SwitchEnum enm = SwitchEnum.findByLabel(enumString);
        if (enm != null) {
            String enumReturn = enm.name() +" : "+ enm;
            switch (enm) {
                case NORTH:
                    return enumReturn +" - Up there.";
                case EAST:
                    return enumReturn +" - Now for sale.";
                case SOUTH:
                    return enumReturn +" - Now with 50% more elephants.";
                default:
                    return "UNHANDLED ENUM : "+ enm.name() +" - "+ enm;
            }
        } else {
            return "UNKNOWN ENUM : "+ enumString;
        }
    }

    public static void main(String[] args) {
        System.out.println(doEnumSwitch("North star"));
        System.out.println(doEnumSwitch("Eastpack rulez!"));
        System.out.println(doEnumSwitch("https://www.southafrica.net/"));
        System.out.println(doEnumSwitch("java.awt.BorderLayout.WEST"));
        System.out.println(doEnumSwitch("I only want to get out of here."));
    }
}