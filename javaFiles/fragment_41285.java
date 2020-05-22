while ((line = br.readLine()) !=null) {
  try {
    ... process one CSV line ...
  } catch (IOException e) {
    ... handle it, the loop will proceed with the next line
  }
}