while(sc.hasNext())
{
  String line = sc.nextLine();
  String elements[] = line.split(" ");
  Process processobject = new Process();
  processobject.setProcess(elements[0],elements[1],elements[2],elements[3],elements[4]);
}