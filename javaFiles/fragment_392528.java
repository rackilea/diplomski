String num = "000123";
    Integer n = Integer.parseInt(num);
    n++;
    int len = num.length();
    System.out.printf("%0" + len + "d", n); //  000124

    // and if you want to store the result
    // back into a string:
    String res = String.format("%0" + len + "d", n);
    System.out.println(res); // 000124