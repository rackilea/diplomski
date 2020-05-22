public void convert(String value) {

    for (int i = 0; i < strings.length; i++) {
        if (strings[i].equals(value)) {

            System.out.println("Value: " + strings[i]);
            System.out.println("Index: " + i);
        }
    }

}