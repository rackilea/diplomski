public static void main(String[] args) {
    for (int i = 0 ; i < 5 ; i++){
        System.out.println(getMonthName(i+1) + " " + (2010 + i));
        displayCalendar(i+1, 2010 + i);
        System.out.println();
    }
}