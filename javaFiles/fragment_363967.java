public int getNextProjectIndex()
{
  int i = 0;
  while(i < projects.length) {
    if (projects[i] == -1)
      return i;
    ++i;
  }
  return -1;
}