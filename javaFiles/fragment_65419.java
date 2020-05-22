String line = "0 : [38, 38, 38, 38, 199, 199, 199, 199, 3004, 3004, 3004, 3004, 
    23, 23]";

int firstSpace = line.indexOf(" ");
int leftSquareBracket = line.indexOf("[");
int rightSquareBracket = line.indexOf("]");

String keyString = line.substring(0, firstSpace);        
String[] valuesString = line.substring(leftSquareBracket + 1, rightSquareBracket)
    .split(", ");

int key = new Integer(keyString);
List<Integer> values = new ArrayList<>(valuesString.length);
for (String value : valuesString) {
    values.add(new Integer(value));
}

Map<Integer, List<Integer>> motPage = new HashMap<>();
motPage.put(key, values);