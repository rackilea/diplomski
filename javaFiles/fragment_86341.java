@DynamoDBTable(tableName = "UserAccounts")
 public class UserAccounts{     
     private String key; // or uuid right away

     @DynamoDBHashKey
     public String getKey() {
         return key;
     }

     public void setKey(String key) {
         this.key = key;
     }

     // ...
 }