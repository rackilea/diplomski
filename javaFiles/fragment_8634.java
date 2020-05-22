public static void main(String[] args){
    int day;
    int month = 5;
    int year = 2018;
    String str;
    Scanner s = new Scanner(System.in);
    day = s.nextInt();
    switch(day) {
        case 1:
            str = "Sunday";
        break;

        case 2:
            str = "Monday";
        break;

        case 3:
            str = "Tuesday";
        break;

        case 4:
            str = "Wednesday";
        break;

        case 5:
            str = "Thursday";
        break;

        case 6:
            str = "Friday";
        break;

        case 7:
            str = "Saturday";
        break;

        default:
            throw new IllegalStateException("'day' cannot be " + day);
    }
    System.out.println(str);
}