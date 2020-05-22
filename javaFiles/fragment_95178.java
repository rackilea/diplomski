Employee2[] eMinus(int index, Employee2[] input) {
     Employee2[] result = new Employee2[input.length - 1];
     for (int i = 0 ; i < index; i++)
         result[i] = input[i];
     for (int i = index + 1; i < input.length; i++)
         result[i - 1] = input[i];
     return result;
}