public boolean ifAllCharsUnique(String input){
    char[] arr = input.toCharArray();
    int length = arr.length;
    Set<Character> checker = new HashSet<>();
    for(int i =0 ; i < length; i++){
         if(checker.contains(arr[i]){
               return false;
         }
         checker.add(arr[i]);
    }
    return true;
}