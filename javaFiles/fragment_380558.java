for (int i = 0; i < string.length(); ++i) {
  switch (string.charAt(i)) {
    case '*': case '/': return i;
  }
}
return -1;