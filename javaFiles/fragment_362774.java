//...
BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
while (true) { //keep reading
    try {
        inputLine = is.readLine();
        int num = Integer.parseInt(inputLine); //make sure it's an integer
        if(num > -1 && num < 10) { // if it is, and within [0-9]
            break; // stop reading
        }
    } catch (Exception e) { // if not prompt again
        System.out.println("pleasse try again with a number within [0-9]");
    }
}
return inputLine; // no to lower case, it's a number