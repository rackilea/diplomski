boolean inQuote = false;
for (int a = 0; a <= contents.length() - 1; a++) {
  char c = contents.charAt(a);
  if (c == '"') {
    // Found a quote character. Are we at the beginning or the end?
    if (!inQuote) {
      // Start of a quoted string.
      inQuote = true;
    } else {
      // End of a quoted string.
      inQuote = false;
      toks.add(tok);
      tok = "";
    }
    // Either way, we don't add the quote char to `tok`.
  } else {
    tok += c;
    if (!inQuote && tokenFinderEquals(tok, "WRITE") {
      // Only look for "WRITE" when outside of a quoted string.
      toks.add(tok);
      tok = "";
    }
  }
}