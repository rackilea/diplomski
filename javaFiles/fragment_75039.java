String[] array = new String[10];
    String b = "10";
    boolean c = false;
    for (int i = 0; i < 10; i++) {
        String in = String.valueOf(i);
        array[i] = in;
    }
    for (int i = 0; i < 10; i++) {
        if (b.equals(array[i])) {
            System.out.println("found " + array[i]);
        } else if (!b.equals(array[i])) {
            c = true;
            }
    }
    if (c == true){
        System.out.println("not found");
    }
}