public static String getAnswer() {

        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine().toLowerCase();
        String firstChar = input.substring(0, 1);
        String secondChar = input.substring(1);

        String[] chars = new String[] { "b", "r", "g", "y" };
        String[] answers1 = new String[] { "Zero Blue", "Zero Red", "Zero Green", "Zero Yellow" };
        String[] answers2 = new String[] { "One Blue", "One Red", "One Green", "One Yellow" };

        if ((firstChar.equals("0"))) {
            for (int i = 0; i < chars.length; i++) {
                if (secondChar.equals(chars[i])) {
                    return answers1[i];
                }
            }
        }
        else if ((firstChar.equals("1"))) {
            for (int i = 0; i < chars.length; i++) {
                if (secondChar.equals(chars[i])) {
                    return answers2[i];
                }
            }
        }
        return "not valid";
    }

    public static void main(String[] args) throws IOException {

        System.out.println(getAnswer());
    }