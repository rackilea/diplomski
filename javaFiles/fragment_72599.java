doForEveryFile(File root)
{
  if (root.isFile()) do_something_with_that_file(root);
  else if (root.isDirectory())
  {
     for (File next_file : root.listFiles()) doForEveryFile(next_file);
  }
}