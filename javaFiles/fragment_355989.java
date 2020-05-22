storedmatch = ""
while matcher.find {
  if matcher.end < offset {
    storedmatch = matcher.group()
  } else {
    return storedmatch
  }
}