String str = "There exists a word *random*.";

int index1 = str.indexOf("*");
int index2 = str.indexOf("*", index1 + 1);

int length = index2 - index1 - 1;   // Get length of `random`

StringBuilder builder = new StringBuilder();

// Append part till start of "random"
builder.append(str.substring(0, index1 + 1));

// Append * of length "random".length()
for (int i = 0; i < length; i++) {
    builder.append("*");
}

// Append part after "random"
builder.append(str.substring(index2));

str = builder.toString();