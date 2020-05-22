hasIllegalCharacters = true;

  ...nested for loops...
    if (newString.charAt(i) != illegalChars[j]) {
      hasIllegalChars = false;
      // optional "break;" or "return false;" statement here
    }
  ...

  return hasIllegalChars;