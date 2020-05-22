String[] number = new String[500]; //1
String[] mark = new String[500];
String num = "12132002(177) 012(207.5) 014(184)";
String[] numSplit = num.split(" "); //2

for(int i = 0; i < numSplit.length; i++) { //3
    number[i] = numSplit[i].substring(0, numSplit[i].indexOf("(")); //4
    mark[i] = numSplit[i].substring(numSplit[i].indexOf("(") + 1, numSplit[i].length() - 1); //5
}

for(int i = 0; i < number.length; i++) System.out.println(number[i]); //6
for(int i = 0; i < mark.length; i++)  System.out.println(mark[i]);