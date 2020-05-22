boolean isPalindrome = true;
    for (int n = 0; n < array.length / 2; n++){
        if (array[n] != array[array.length - n - 1]) {
            isPalindrome = false;
            break;
        }
    }
    if (isPalindrome) {
        System.out.println("This word is a Palindrome!");
    } else {
        System.out.println("This word is not a Palindrome!");
    }