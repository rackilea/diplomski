String[] toppings = {"1234", "56789", "123456"};

for (int q = 0; q < toppings.length; q++){

    int length = toppings[q].length(); // # of digits
    int maxlength = 9;

    if (length<maxlength){ // only do this if it is below 9
        for (int i = length; i < maxlength; i++){ // go through and add 0's
            toppings[q] = toppings[q] + "0";
        }
    }
}

String mix = "";
for (int q = 0; q < toppings.length; q++){ // add all the strings to one single string
    mix+=toppings[q];
}

System.out.println(mix);