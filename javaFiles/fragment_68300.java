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
    result[i] = mText.substring(j, splitpoint).trim();
    j = splitpoint;
}

result[lastIndex] = mText.substring(j).trim();