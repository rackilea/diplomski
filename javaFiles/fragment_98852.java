import com.greytip.common.utils.StringUtils;

public class Test {
    public static void main(String[] args) {
        Object[] array = new Object[11];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;

        }
        recursive(array);
    }

    private static void recursive(Object[] array) {
        if (array == null || array.length < 2) {
            System.out.println("return: " + StringUtils.join(array));
            return;
        }

        int pos = x(array);

        Object[] part1 = new Object[pos];
        Object[] part2 = new Object[array.length - pos];
        System.out.println("array : " + StringUtils.join(array)
                + ", part1: 0.." + pos + ", part2: " + part1.length + ".."
                + part2.length);

        System.arraycopy(array, 0, part1, 0, part1.length);
        System.arraycopy(array, part1.length, part2, 0, part2.length);

        recursive(part1);
        recursive(part2);

    }

    private static int x(Object[] array) {
        return array.length / 2;
    }
}