public static ListItem evenElements(ListItem ls) {
    ListItem output = null;

    ListItem current = ls;

    // While the next item exists
    while (current != null){

        // If it's even
        if (current.number % 2 == 0) {

            // If it's the first time we see an even number, initialize output
            if (output == null) {
                output = current.duplicate();
            }
            // Otherwise append this even number to our list of even numbers
            else {
                output.next = current.duplicate();
                output = output.next;
            }
        }
        // Move the next item
        current = current.next;
    }
    if (output != null) {
        output.next = null;
    }
    return output;
}