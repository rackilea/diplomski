import java.util.ArrayList;
import java.util.Iterator;

 public class DropTest {

    class DropItem {
       private String objectId;

       public String getObjectId() {
          return objectId;
       }

       public DropItem(String id) {
          this.objectId = id;
       }
    }

    public static void main(String[] args) {
        new DropTest().test();
    }

    public void test() {
        ArrayList<DropItem> allDropsList = new ArrayList<>();       
        allDropsList.add(new DropItem("one"));
        allDropsList.add(new DropItem("two"));
        allDropsList.add(new DropItem("three"));
        allDropsList.add(new DropItem("four"));
        allDropsList.add(new DropItem("five"));

        ArrayList<DropItem> hasReleationList = new ArrayList<>();
        hasReleationList.add(new DropItem("three"));
        hasReleationList.add(new DropItem("five"));

        System.out.println("before:");
        for(DropItem dropItem : allDropsList) {
           System.out.println(dropItem.getObjectId());
        }

        ArrayList<DropItem> result = filterDrops(hasReleationList, allDropsList);
        System.out.println("\n\nafter:");
        for(DropItem dropItem : result) {
           System.out.println(dropItem.getObjectId());
        }
   }

   public ArrayList<DropItem> filterDrops(ArrayList <DropItem> hasRelationList, ArrayList <DropItem> allDropsList) {
       Iterator<DropItem> allDropsIterator = allDropsList.iterator();

       while(allDropsIterator.hasNext()) {
          DropItem dropItemAll = allDropsIterator.next();

          for(DropItem dropItemRelation  : hasRelationList) {
              if(dropItemAll.getObjectId().equals(dropItemRelation.getObjectId())){
                  allDropsIterator.remove();
              }
          }
      }

      return allDropsList;
   }
}