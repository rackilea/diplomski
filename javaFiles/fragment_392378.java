public class ProgramItem {
   ....
   int getAsMins() {
      return hours *60 + mins;
   }
}
....
Collections.sort(items, new Comparator<ProgramItem>() {
        public int compare(ProgramItem item1, ProgramItem item2) {
           return item1.getAsMins() - item2.getAsMins();
        }
});