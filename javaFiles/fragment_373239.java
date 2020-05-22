int activityNumber = 1;
while ((line = reader.readLine()) != null) {

   ArrayList<WorkUnit> activity = new ArrayList<WorkUnit>();

   //1st place is activity id; always ascending order 0 to n
   splitedLine = line.split(" ");
   // we know that value t will be the middle element.
   int len = splitedLine.length;
   for(int i=0; i<splitedLine.length/2; i++) {
       int workerId = Integer.parseInt(splitedLine[i]);
       int duration = Integer.parseInt(splitedLine[len - i - 1]);
       activity.add(new WorkUnit(activityNumber, workerId, duration));
   }

   activityNumber++;

   acrivityLists.add(activity);

}