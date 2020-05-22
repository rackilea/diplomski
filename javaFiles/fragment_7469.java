public static double evaluate(int[] array) {
    double something = 0;
    int rule1Occurences = testRule1(array);
    int rule2Occurences = testRule2(array);
    System.out.println(rule1Occurences);
    System.out.println(rule2Occurences);
    return something;//not sure how rules relate
}
//This counts when array element == next array element
public static int testRule1(int[] array){
    int ruleSat = 0;
    for (int index = 0; index < array.length; index++) {
        if (index != array.length - 1) {
            if ((array[index] == array[index + 1]) && (index % 2 == 0)) {
                ruleSat++;
            }
        }
    }
    return ruleSat;     
}
//This blocks the pairs off in sets of two disregarding any odd parings
public static int testRule2(int[] array)
{
    int rule2Sat = 0;
    for (int index = 0; index < array.length; index++) {
        if(index <= array.length - 4){
            if (array[index] + array[index+1] == array[index+2] + array[index+3]) {
                rule2Sat++;
            }
        }
    }
    return rule2Sat;    
}

public static void main(final String[] args) {

    int[] dataSet = new int[6];
    dataSet[0] = 0;
    dataSet[1] = 0;
    dataSet[2] = 0;
    dataSet[3] = 0;
    dataSet[4] = 4;
    dataSet[5] = 4;

    System.out.println(evaluate(dataSet));
}