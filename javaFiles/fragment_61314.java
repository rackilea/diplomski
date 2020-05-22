public void yes(int[] phone, int x, int y, int z) {
    int code = x+y+z; // I don't know how you constructed your code but lets say it is a code of 3 digits x,y,z that give the number xyz (e.g. 1,2,3 -> 123)
    for (int count = 0; count < phone.length; count++) {  // you need to iterate through the complete phone number. Which means that your loop starts at 0 and stops when reaching the end (length) of your phone array
        phone[count] = (your calculation here) // you replace each digit from the phone array by the result of that calculation
    }
}