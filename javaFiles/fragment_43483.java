public static void main(String[] args) {
    System.out.println(getDays(88)); // [WED, THU, SAT]
}

public static List<String> getDays(int input){
    List<String> days = new ArrayList<String>();
    String[] daysArr = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    for (int i = 0 ; i < 7 ; i++){
        if ((input & 1 << i) != 0){
            days.add(daysArr[i]);
        }
    }
    return days;
}