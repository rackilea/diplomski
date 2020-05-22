public int getClosestInteger(int value, int[] numbers) {
    for (int i = 0; i < numbers.length; i++){
        if(value < numbers[i]){
            return numbers[i];
        }
    }
}