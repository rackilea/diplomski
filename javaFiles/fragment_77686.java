boolean swap = false;
for(int j = 0; j < number1.length && negative; j++){
    if(number2[j] > number1[j]){
        swap = true;                
        int temp[] = number1;
        number1 = number2;
        number2 = temp;
        break;
    } else if(number1[j] > number2[j]){
        break;
    }
}

int[] result = new int[number1.length];
int carry = 0;
for(int i = number1.length - 1; i >= 0; i--) {
    int newDigit = (negative ? number1[i] - number2[i] : number1[i] + number2[i]);

    newDigit += carry;
    if (newDigit >= 10) {
        carry = 1;
        newDigit -= 10;
    } else if (newDigit < 0) {
        carry = -1;
        newDigit += 10;
    } else {
        carry = 0;
    }
    result[i] = newDigit;
}

// Convert result back into a string.
String resultString = "";
for(int j = 0; j <result.length; j++){
    resultString += (result[j] + "");
}

// Apply carry.
if(carry == 1) {
    return "1" + resultString;
} else if(carry == -1 || swap) {//if swap is set sign is - 
    return "-" + resultString;
} else {
    return resultString;
}