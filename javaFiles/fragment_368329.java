import java.util.ArrayList;
import java.util.List;


public class Main {

 public static void main(String args[]){

    ShareTypesTrue sharetypetrue = new  ShareTypesTrue();

    //Create object
    ShareType shareType = new ShareType();
    shareType.setShareTypeName("Original Name");

    //Create list
    List<ShareType> shareTypes=new ArrayList<ShareType>();
    shareTypes.add(shareType);

    //Attach it to share
    sharetypetrue.setShareType(shareTypes);

    //Print
    for(ShareType shareTypesMember:sharetypetrue.shareType){
        System.out.println(shareTypesMember.shareTypeName);
    }

    //Editing it.
    for(ShareType shareTypesMember:sharetypetrue.shareType){
        shareTypesMember.shareTypeName = "Updated Name";
    }
    //Print
    for(ShareType shareTypesMember:sharetypetrue.shareType){
        System.out.println(shareTypesMember.shareTypeName);
    }
 }
}