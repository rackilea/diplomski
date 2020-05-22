String[] array = new String[5];

array[0] = "This";
array[1] = null;
array[2] = "is";
array[3] = null;
array[4] = "a test";

int count = Collections.frequency(Arrays.asList(array), null);

System.out.println("String: " + count + " items out of " + array.length + " are null");

int[] iArray = new int[3];
iArray[0] = 0;
iArray[1] = 1;
iArray[2] = 2;

List<Integer> iList = new ArrayList<>();

for (int i : iArray) {
    iList.add(i);
}

int iCount = Collections.frequency(iList, 0);

System.out.println("Int: " + iCount + " items out of " + iArray.length + " are zero");

char[] cArray = new char[3];
cArray[0] = 'c';
cArray[1] = ' ';
cArray[2] = 'a';

List<Character> cList = new ArrayList<>();

for (char c : cArray) {
    cList.add(c);
}

int cCount = Collections.frequency(cList, ' ');

System.out.println("Char: " + cCount + " items out of " + cArray.length + " are ' '");