public class Sort {

    enum Sides {
        left, middle, right
    }

    public static void main(String[] param) {
        Sides[] list = {Sides.middle, Sides.right, Sides.left, Sides.middle, Sides.left};

        order(list);
        System.out.print("Ordered: ");
        for (Sides side : list) {
            System.out.print(side.toString() + ", ");
        }
    }

    public static void order(Sides[] sides) {
        Sides[] possibleValues = Sides.values();

        int[] counts = new int[possibleValues.length];
        for (Sides side : sides) {
            counts[side.ordinal()]++;
        }

        int i=0;
        for (int j = 0; j < counts.length; j++)
            for (int k = 0; k < counts[j]; k++)
                sides[i++] = possibleValues[j];

    }
}