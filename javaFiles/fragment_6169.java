public static void main(String args[]) throws IOException
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    for(int i = 0; i < cases; i++)
    {
        int letters = new int[26];
        String word = br.readLine().toUpperCase();
        int lengthOfWord = word.length();
        for (int j = 0; j < lengthOfWord; j++)
        {
            letters[word.charAt(j) - 'A']++;
        }
        int factorialProduct = 1;
        for (int j = 0; j < letters.length; j++)
        {
            factorialProduct *= factorial(letters[j]);
        }
        int result = factorial(lengthOfWord) / factorialProduct;
        System.out.printf("Data set %d: %d\n",iteration,result);
    }
}