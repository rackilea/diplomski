int[] intArray = new int[] { 4, 2, 2, 6, 2 };
String[] strArray = new String[] { "Register & Head of Administration", "Web Designing", "IT - Software Engineer", "Accountant", "Network Engineer" };
int tmp0 = 0;
String tmp1 = "";
for (int i = 0; i < intArray.length; i++) {

    for (int j = i + 1; j < intArray.length; j++) {

        if (intArray[j] > intArray[i]) {

            // swap in int-Array
            tmp0 = intArray[i];
            intArray[i] = intArray[j];
            intArray[j] = tmp0;

            // swap in string-Array
            tmp1 = strArray[i];
            strArray[i] = strArray[j];
            strArray[j] = tmp1;
        } else if (intArray[j] == intArray[i]) {

            // sorts alphabetically
            if (strArray[j].compareTo(strArray[i]) < 0) {

                tmp1 = strArray[i];
                strArray[i] = strArray[j];
                strArray[j] = tmp1;
            }
        }
    }
}

//output
for (int k = 0; k < intArray.length; k++) {

    System.out.println(strArray[k] + " " + intArray[k]);
}