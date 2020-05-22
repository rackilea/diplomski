String data[] = { "0", "0", "0", "K", "K", "B", "P", "P", "P", "Z", "Z", "D", "D", "E", "E", "F", "N" };
// a = ['0','0','0','K','K','P','P','P','Z']

Stack<String> stack = new Stack<String>();
String prevValue = data[0];

for (int i = 1; i < data.length; i++) {
    if (data[i].equals(data[i - 1])) {
        prevValue = prevValue + data[i];
    } else {
        stack.push(prevValue);
        prevValue = data[i];
    }
}
stack.push(prevValue);
System.out.println(stack);