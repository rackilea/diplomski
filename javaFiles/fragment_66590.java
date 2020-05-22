@Override
public String toString() {
    String output = "";
    for (Integer i : a) {
        output += i.toString() + " ";
    }
    return "[" + output + "]";
}