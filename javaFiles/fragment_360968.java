int length = 1; // the length of the current run
int number = a[0]; // the number currently being repeated
for(int i = 1; i < a.length; i++) {
    if(a[i] == number)
        length++;
    else {
        if(length > 1) {
            System.out.print("(");
            for(int j = 0; j < length; j++)
                System.out.print(number);
            System.out.print(")");
        } else {
            System.out.print(number);
        }
        number = a[i];
        length = 1;
    }
}
if(length > 1) { // last run
   System.out.print("(");
   for(int j = 0; j < length; j++)
       System.out.print(number);
   System.out.println(")");
} else {
    System.out.println(number);
}