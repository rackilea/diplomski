int limit = 3, current = 0;
StringBuilder sb = new StringBuilder();

// Used as an example of input
String str = "test,west,best,zest,jest";

String[] strings = str.split(",");

for(String s : strings) {
    if(++current > limit) {
        // We've reached the limit; bail
        break;
    }
    if(current > 1) {
        // Add a comma if it's not the first element. Alternative is to
        // append a comma each time after appending s and remove the last
        // character

        sb.append(",");
    }

    sb.append(s);
}
System.out.println(sb.toString()); // Prints "test,west,best"