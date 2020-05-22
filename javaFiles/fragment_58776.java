public String toString() {
    String result = "";

    for (int scan = 0; scan < top; scan++)
        result = result + stack[scan].toString() + "\n";

    return result;
}