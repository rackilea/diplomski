public static void main(String[] args) {
    // TODO Auto-generated method stub
    String sInput = "";
    Scanner sc = new Scanner(System.in);
    System.out.print("Input alphabetical character string: ");
    sInput = sc.next();
    if (!hasTwoVowels(sInput)) {
        System.out.println("Error, sequence requires a minimum of two vowels");
        sc.next();
    }
    sc.close();
  }
  public static boolean hasTwoVowels(String sInput){
    int iCount = 0;
    String vowel[] = new String[]{"a","e","i","o","u","A","E","I","O","U"};
            for(int i =0; i < 10;i++) {
                if(sInput.contains(vowel[i])) {
                    iCount++;
                    if(iCount == 2) {
                        return true;
                    }
                }
            }
            return false;
     }
  }