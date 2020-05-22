char[] newChars = new char[chars.length];
int left = 0;
int right = chars.length;

for (char c : chars) {
  if (c == '!') {
    newChars[left++] = c;
  } else {
    newChars[--right] = c;
  }
}

// Reverse the "otherSymbols".
for (int i = right, j = newChars.length - 1; i < j; ++i, --j) {
  char tmp = newChars[i];
  newChars[i] = newChars[j];
  newChars[j] = tmp;
}

return new String(newChars);