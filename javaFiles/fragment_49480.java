class Printer {

    public static void print(String listTitle, List<E> listToPrint) {
        StringBuilder string = new StringBuilder();
        string.append(listTitle);

        for (E request : listToPrint) {
            string.append("\n").append(request);
        }
    }
}