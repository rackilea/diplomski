String msg = "johnny can't program, he can only be told what to type";

char[] mychararray = msg.toCharArray();
mychararray = remove_one_character_from_a_character_array_in_java(mychararray, 21);
System.out.println(mychararray);

public char[] remove_one_character_from_a_character_array_in_java(
                           char[] original, 
                           int location_to_remove)
{
    char[] result = new char[original.length-1];
    int last_insert = 0;
    for (int i = 0; i < original.length; i++){
        if (i == location_to_remove)
            i++;

        result[last_insert++] = original[i];
    }
    return result;
}

//The above method prints the message with the index removed.