int sum = 0;
String test = "42932-5";
List<Integer> listValues = new ArrayList<Integer>(test.length());
for (int index = 0; index < test.length(); index++) {

    char value = test.charAt(index);
    if (Character.isDigit(value)) {

        listValues.add(Integer.parseInt(Character.toString(value)));

    }


}