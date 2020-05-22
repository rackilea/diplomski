public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] list = { 3, 5, 2, 2, 6, 3, 6, 3, 6, 3, 6, 2, 2, 1 };
        System.out.print(palindrome(list));
    }

    public static int palindrome(int[] list) {
        int output = -1;
        for (int i = 0; i < list.length; i++) {
            int num = list[i];
            ArrayList<Integer> indices = getIndices(list, i, num);
            for (int j = 0; j < indices.size(); j++) {
                boolean flag = true;
                int k = i;
                for (int l = indices.get(j); l >= k; l--, k++) {
                    if (list[k] != list[l]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    int length = (indices.get(j) - i) + 1;
                    if (length != 1 && length > output) {
                        output = length;
                    }
                }
            }
        }
        return output;
    }

    public static ArrayList<Integer> getIndices(int[] list, int start, int num) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = start + 1; i < list.length; i++) {
            if (list[i] == num) {
                result.add(i);
            }
        }

        return result;
    }

}