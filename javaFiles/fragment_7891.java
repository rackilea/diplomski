final String EOF = new String();

// Producer
while ((line = br.readLine()) != null)
  queue.put(line);
br.close();
// signal end of input
queue.put(EOF);

// Consumer
while (true)
  {
    try
      {
        String line = queue.take();
        // Reference equality
        if (line == EOF)
          break;
        System.out.println(line);
        linesWrote++;
      }
    catch (InterruptedException ie)
      {
      }
  }