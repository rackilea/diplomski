public static void main(String[] args) {
    String mText =  "I am able to break up paragraphs of text into substrings based upon nth given character limit. The conflict I have is that my algorithm is doing exactly this, and is breaking up words. This is where I am stuck. If the character limit occurs in the middle of a word, how can I back track to a space so that all my substrings have entire words?";

    int charLimit = 40;
    int arrayLength = 0;
    arrayLength = (int) Math.ceil(((mText.length() / (double) charLimit)));

    String[] result = new String[arrayLength];
    int j = 0;
    int tolerance = 10;
    int splitpoint;
    int lastIndex = result.length - 1;
    for (int i = 0; i < lastIndex; i++) {
        splitpoint = mText.lastIndexOf(' ' ,j+charLimit);
        splitpoint = splitpoint > j+charLimit-tolerance ? splitpoint:j+charLimit;
        result[i] = mText.substring(j, splitpoint);
        j = splitpoint;
    }

    result[lastIndex] = mText.substring(j);

    for (int i = 0; i<arrayLength; i++) {
        System.out.println(result[i]);
    }
}