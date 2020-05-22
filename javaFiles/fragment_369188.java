line = keyboard.nextLine();
    if (line.isEmpty()) {
        break;
    }
    String arr[] = line.split(" ");// spiting the line based on space
    if (arr.length==4) { // check if length is 4 as you are expecting
    // use Integer.valueOf() to convert from string to Integer
        power.add(arr[0]);
        energy.add(arr[1]);
        idea.add(arr[2]);
        strength.add(arr[3]);
    }else {
        //throw exception or break
    }
    input += line + "\n";
}