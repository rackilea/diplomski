public void List() {
System.out.println("+--------+--------+");
System.out.println("| Number | Occurs |");
System.out.println("+--------+--------+");

while(index > 0){
    int del = array[0];
    int count = Count(del);
    System.out.printf("|%8d|%8d|\n", del, count);
    System.out.println("+--------+--------+");
    for(int j = 0; j < count; j++){
        delete(del);
    }
}