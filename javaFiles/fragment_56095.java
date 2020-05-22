String[] arr = myString.split(".");
int[] indices = { 1, 7 };
int length = indices.length;

StringBuilder str = new StringBuilder();
for (int i=0; i<length; i++) {
    str.append(arr[indices[i]]);
    if (i+1 != length) str.append(".");
}

String result = str.toString();