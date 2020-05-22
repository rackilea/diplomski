public static void main(String args[]){
    int length = 2; //here read the input from scanner
    String[] array = {"a", "b"}; //here read this input from scanner
    String max = maxElement(array,0,length);
    System.out.println(max);
}

public static String maxElement(String[] start, int index, int length) {
    if (index<length-1) {
        return "Math.max(" + start[index]  +  ", " + maxElement(start, index+1, length)+ ")";
    } else {
        return start[length-1];
    }
}