Scanner s = new Scanner(System.in);
    String input = "";
    String message = "";
    System.out.print("Enter the message to encrypt: ");
    input = s.next();  // this message is inserted

    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0;i<input.length();i++){
        if(i>0 && input.charAt(i) == input.charAt(i-1)){
                stringBuilder.append("X");
                stringBuilder.append(input.charAt(i));

        }else{
            stringBuilder.append(input.charAt(i));
        }
    }

    if ( (stringBuilder.length() & 1) != 0 ) {
        stringBuilder.append("X");
    }
    message = stringBuilder.toString();
    List<String> strings = new ArrayList<String>();

    int index = 0;
    while (index < message.length())
    {
        strings.add(message.substring(index, Math.min(index + 2,
                message.length())));
        // separates the list by two's. i.e. [ST, EV, EN] for "Steven"
        index += 2;
    }
    System.out.println(strings); // prints out list