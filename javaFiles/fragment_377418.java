int c = 0;
switch (c) {
    case 1:
        Object obj = new Object();
        break;
    case 2:
        System.out.println(obj.toString()); // obj only exists in case 1
        break;
}