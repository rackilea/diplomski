public Matcher appendReplacement (StringBuffer sb, String replacement)
    throws IllegalStateException
  {
    assertMatchOp();
    sb.append(input.subSequence(appendPosition,
                                match.getStartIndex()).toString());
    sb.append(RE.getReplacement(replacement, match,
        RE.REG_REPLACE_USE_BACKSLASHESCAPE));
    appendPosition = match.getEndIndex();
    return this;
  }