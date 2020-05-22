List<Integer> daysList = new ArrayList<>();
int day = 6;

for (int i = 0; i < 6; i++) {
    daysList.add(day);
    day++;
    if(day > 6) day = 1;
}

System.out.println("Day Num :" + daysList);