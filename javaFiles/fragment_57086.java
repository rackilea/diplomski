Scanner s=new Scanner(System.in);
String str;
int k=0;
String[][] cartoons = {
        { "Flintstones", "Fred is a bad boy."},
        { "Rubbles", "Barney rocks."},
        { "Jetsons", "George was president of America."},
        { "Scooby Doo Gang", "Scooby Doo where are you?"} };
boolean found=false;

for (int i = 0; i < cartoons.length; i++) {
    System.out.print(cartoons[i][0] + ": ");
    for (int j = 1; j < cartoons[i].length; j++) {
        System.out.print(cartoons[i][j] + " ");
    }
    System.out.println();
}
System.out.println("Enter name to search.");
str=s.nextLine();
while(!found && k<cartoons.length){
    if(str.equals(cartoons[k][0])){
        System.out.print(cartoons[k][1]);
        found=true;
    }
    k++;
}
if (!found) {
    System.out.println("Not found");
}