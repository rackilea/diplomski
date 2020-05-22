int[] categories = new int[4];

// ...set the values for the categories directly...
// ...or copy them like this:
// categories[0] = catOne; 
// categories[1] = cat2; 
// categories[2] = cat3;
// categories[3] = cat4;

int maximum = 0;
for (int value : categories) {
    if(value > maximum) {
        maximum = value;
    }
}

// The above loop is the short version of:
// for (int i = 0; i < categories.length; i++) {
//     if (categories[i] > maximum) {
//         maximum = categories[i];
//     }
// }

// Added "00", so the colums have equal width
System.out.println("00-29  30-39  40-69  70-100\n");

for (int i = 0; i < maximum; i++) {
    for (int j = 0; j < 4; j++) {
        if (categories[j] > i) {
            System.out.print("*      ");
        } else {
            System.out.print("       ");
        }
    }
    System.out.println();
}