package models;
import com.avaje.ebean.config.ServerConfig;     
import com.avaje.ebean.event.ServerConfigStartup;     
import com.avaje.ebean.config.EncryptKey;       
import com.avaje.ebean.config.EncryptKeyManager; 

public class CustomServerConfigStartup implements ServerConfigStartup { 

    @Override 
    public void onStart(ServerConfig serverConfig) {     
          serverConfig.setEncryptKeyManager(new BasicEncryptKeyManager());     
    }     
} 

class BasicEncryptKeyManager implements EncryptKeyManager{ 

 @Override 
 public EncryptKey getEncryptKey(String tableName, String columnName) {     
       return new CustomEncryptKey(tableName, columnName);     
 } 

 @Override 
 public void initialise() { 
     //Do nothing (yet)
 } 

} 

class CustomEncryptKey implements EncryptKey{ 

   private String tableName;

   private String columnName;

   public CustomEncryptKey(String tableName, String columnName){
      this.tableName = tableName;
      this.columnName = columnName;
   }

 @Override 
 public String getStringValue() {     
        return play.Configuration.root().getString("application.secret") + "::" + this.tableName + "::" + this.columnName;      
 }     
}