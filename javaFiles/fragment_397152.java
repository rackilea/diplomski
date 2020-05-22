/**
 * The following code is only for demonstration purposes.
 * It does neither do any validation on the input String 
 * nor work with more than one digit numbers.
 */

static int index = 0; // the position in the String

Object buildList(String nestedList) {
    List<Object> list = new ArrayList<>();

    while (index < nestedList.length()) {
        char c = nestedList.charAt(index++);

        if (c == '[') // add a sub-list via a recursive call
                list.add(buildList(nestedList));
        else if (c == ']') // stop building the list
                 break;
        else if (c == ',') {} // do nothing
        else // add an element to the list
            list.add(c);
    }

    return list;
}