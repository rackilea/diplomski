input = new FileReader(txt);
count = new BufferedReader(input);
String line = null;
while(( line = count.readLine())!= null){ //each line is read and assigned to the String line variable.
        System.out.println(line);
        result++;
 }