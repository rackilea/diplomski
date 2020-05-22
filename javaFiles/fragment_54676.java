for each column {
  used = new set
  for each cell in column {
    do {
      num = generate random number
    } while (num already in used)
    add num to used
    add num to the current cell
  }
}