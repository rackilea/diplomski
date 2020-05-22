import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;




public class HelloWorld{


 public static void main(String []args){
    List matches = new ArrayList();


    Pattern p = Pattern.compile("\\*\\*name=(.*?)\\*\\*");

    String data = "[{uuid=80461af7-f6c7-448d-8aea-a5fd07bd4cfc, folderId=92711, groupId=10202, companyId=10154, userId=10198, userName=Test Test, createDate=Wed Feb 04 02:32:19 GMT 2015, modifiedDate=Thu Feb 05 13:54:46 GMT 2015, repositoryId=10202, mountPoint=false, parentFolderId=92703, treePath=/92703/92711/, **name=Cyber**, description=, lastPostDate=Wed Feb 04 02:32:19 GMT 2015, defaultFileEntryTypeId=0, hidden=false, overrideFileEntryTypes=false, status=0, statusByUserId=0, statusByUserName=, statusDate=null}, {uuid=51d3719c-d787-49c1-a565-bd40e6515154, folderId=92715, groupId=10202, companyId=10154, userId=10198, userName=Test Test, createDate=Wed Feb 04 02:32:43 GMT 2015, modifiedDate=Wed Feb 04 02:32:43 GMT 2015, repositoryId=10202, mountPoint=false, parentFolderId=92703, treePath=/92703/92715/, **name=Operational**, description=, lastPostDate=Thu Feb 05 05:04:43 GMT 2015, defaultFileEntryTypeId=0, hidden=false, overrideFileEntryTypes=false, status=0, statusByUserId=0, statusByUserName=, statusDate=null}, {uuid=06bf396f-7814-431d-8e3d-2488a757d970, folderId=92707, groupId=10202, companyId=10154, userId=10198, userName=Test Test, createDate=Wed Feb 04 02:31:57 GMT 2015, modifiedDate=Thu Feb 05 13:54:21 GMT 2015, repositoryId=10202, mountPoint=false, parentFolderId=92703, treePath=/92703/92707/, **name=SAS**, description=, lastPostDate=Wed Feb 04 02:31:57 GMT 2015, defaultFileEntryTypeId=0, hidden=false, overrideFileEntryTypes=false, status=0, statusByUserId=0, statusByUserName=, statusDate=null}]" ; 

    Matcher m = p.matcher(data);
    int index = 0;
    while(m.find(index)) {
        matches.add(m.group(1));
        System.out.println(m.group(1));
        index = m.end();
    }

 }
}