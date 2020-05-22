hashFunction1(String s){
    int k = 7;         //take a prime number, can be anything (I just chose 7)
    for(int i = 0; i < s.length(); i++){
        k *= (23 * (int)(s.charAt(i)));
        k += (int)(s.charAt(i));
        k %= capacity;
    }
}