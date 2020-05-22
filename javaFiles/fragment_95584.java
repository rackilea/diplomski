int exp = holdDigits.length;
    System.out.println("exp: " + exp);
    int index = 0;
    while (n > 0){
        holdDigits[index] = n%10;
        System.out.println(index + "index: " + holdDigits[index]);
        n = n/10;
        System.out.println("remainder: " + n);
        index++;
    }
    index--;
    int count= index;
    while (index >=0 ){
        reverseNumber += holdDigits[count-index]*Math.pow(10,index);
        index--;
        System.out.println("sum so far: " + sum);
    }