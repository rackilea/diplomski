int j = 1;
for(int i = 0; i < 3; i++) {
    j = 1; //reset the value each time through the outer loop
    for(; j < 3; j++) {
        System.out.println(i + "" + j);
    }
}