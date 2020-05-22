public class IntArrayColumn implements RushColumn<int[]> {

    private static final String DELIMITER = ",";

    @Override
    public String sqlColumnType() {
        return "varchar(255)";
    }

    @Override
    public String serialize(int[] ints, RushStringSanitizer rushStringSanitizer) {
        return rushStringSanitizer.sanitize(join(ints));
    }

    @Override
    public int[] deserialize(String s) {
        return split(s);
    }

    @Override
    public Class[] classesColumnSupports() {
        return new Class[]{int[].class};
    }

    private String join(int[] ints) {
        if (ints.length > 0) {
            StringBuilder sbuild = new StringBuilder();
            for (int i = 0; i < ints.length; i++) {
                sbuild.append(ints[i]).append(DELIMITER);
            }
            sbuild.delete(sbuild.lastIndexOf(DELIMITER), sbuild.length());
            return sbuild.toString();
        } else {
            return "";
        }
    }

    private int[] split(String source) {
        if (source != null) {
            if (source.isEmpty()) {
                return new int[0];
            }
            String[] items = source.split(DELIMITER);
            int[] ints = new int[items.length];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = Integer.valueOf(items[i]);
            }
            return ints;
        }
        return null;
    }
}