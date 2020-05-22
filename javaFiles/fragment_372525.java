Thread.sleep(200);
  BufferedInputStream input = new BufferedInputStream(in);

  while ((value = input.read()) != 1 && index < 200)
  {
    compute(value);
    index++;
  }
  input.close();