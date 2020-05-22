public class Main {

    public static void main(String bicycle[]) {
        List<String> texts = new ArrayList<String>();
        texts.add("4\"");
        texts.add("4.5\"");
        texts.add("5.5\"");
        System.out.println(checkAscendingOrderScreensize(texts));
          // prints true

    }

    public static boolean checkAscendingOrderScreensize(List<String> list) {

        if (list == null || list.isEmpty())
            return false;

        if (list.size() == 1)
            return true;

        for (int i = 1; i < list.size(); i++) {
            String current = list.get(i).toString();
            String previous = list.get(i - 1).toString();
            current = current.replace(",", ".");
            current = current.replace("\"", "");
            previous = previous.replace(",", ".");
            previous = previous.replace("\"", "");

            if(Double.valueOf(current)<Double.valueOf(previous))


                return false;
        }

        return true;
    }

}