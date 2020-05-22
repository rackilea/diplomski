public static void main(String[] args) {
    //Build random values
    Random rand = new Random();

    //Name random index 3-10 char
    int nmax = 10;
    int nmin = 3;
    int rand1 = (int)(Math.random() * (nmax - nmin + 1) + nmin);
    //Create random name from total number of letters
    //Define Array of letters
    String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    //Create random index to pull a random letter over the length of the random index
    int lmax = 25;
    int lmin = 0;

    ArrayList<String> name = new ArrayList<>(5);
    //I have also tried declaring newName and nameFinal here
    for(int i = 0; i <= rand1; i++) {
        int randl = (int)(Math.random() * (lmax - lmin + 1) + lmin);
        name.add(letters[rand1]);
    }
    //Concatenate array of random letters into a "name"
    //String nameFinal = Arrays.toString(newName);

    //Age random number between 1 and 100
    int amax = 100;
    int amin = 1;
    int rand2 = (int)(Math.random() * (amax - amin + 1) + amin);

    //SSN random 9 digit number
    int smax = 999999999;
    int smin = 100000000;
    int rand3 = (int)(Math.random() * (smax - smin + 1) + smin);

    //Redefine outputs to random values
    System.out.println(name.toString());
}