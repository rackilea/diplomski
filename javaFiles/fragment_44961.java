Stack<Character> fwd = new Stack<>();
Stack<Character> rev = new Stack<>();

/**/
for (int i =0; i < st1.length(); i++) {
    fwd.push(st1.charAt(i));
}
for (int j = st1.length()-1; j >= 0; j--) {
    rev.push(st1.charAt(j));
}
while (!fwd.isEmpty() && !rev.isEmpty()) {  // make sure stack in not empty
        if (fwd.pop()==rev.pop()) //check if fwd pop and rev pop are the same
           palindrome = true;
        else {
           palindrome = false;
           break; //here break the while loop it's not a palindrom
        }
}// end while loop