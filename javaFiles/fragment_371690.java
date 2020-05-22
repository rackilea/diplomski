String numbers = "12 1 890 65";
String[] tokens = numbers.split(" ");
int[] ary = new int[tokens.length];

int i = 0;
for (String token : tokens){
    ary[i++] = Integer.parseInt(token); 
}