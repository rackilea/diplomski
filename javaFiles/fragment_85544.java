public interface SuperList extends List {

   default int count() {
      return size();
   }
}