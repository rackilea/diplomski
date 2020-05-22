import java.io.*;
import java.util.*;

/**
 * refactored by your code
 * append object stream haven't realized,please help 
 * 2013-12-31
 */
public class Reminder implements Serializable {


    public static void main(String[] args) {

        //do some initialization 
        Reminder re = new Reminder();
        re.put(new Date(System.currentTimeMillis()), "Hope it work!");
        re.put(new Date(System.currentTimeMillis()+100), "it work!");
        re.put(new Date(System.currentTimeMillis()+200), "Wake up!");

        //save to file ,using append mode
        String filpath = "/tmp/reminder.ser";
        re.save(filpath,true);

        //load from file and iterate the key-value pair
        Reminder reLoad = Reminder.Load(filpath);
        if(reLoad != null) {
            Iterator<Map.Entry<Date,String>> it = reLoad.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry<Date,String> entry = it.next();
                System.out.format("reminder: %tc---%s%n",entry.getKey(),entry.getValue());
            }
        }
    }
    public Set<Map.Entry<Date,String>> entrySet() {
        return reminderMap.entrySet();
    }
    public void put(Date chosenDate, String string) {
        reminderMap.put(chosenDate, string);
    }
    public String get(Date chosenDate) {
        return reminderMap.get(chosenDate);
    }
    /**
     * serializing an object
     * @param filePath path to save file
     * @param append  indicate whether append or not
     */
    public void save(String filePath,boolean append){
        System.out.println("Trying to save");
          try
          {
             ObjectOutputStream out = new ObjectOutputStream
             ( new FileOutputStream(filePath,append));
             out.writeObject(this);
             out.close();
             System.out.printf("Serialized data is saved in "+filePath);
          }catch(IOException e)
          {
              e.printStackTrace();
          }
    }
    /**
     * deserialize ,load from file and rebuild object
     * @param filePath the path from where to load
     * @return a new Object
     */
    public static Reminder Load(String filePath) {
        System.out.println("Trying to load");
        Reminder reminder = null;
        try
        {
            ObjectInputStream in = new ObjectInputStream
                 (new FileInputStream(filePath));
            reminder = (Reminder) in.readObject();
            in.close();
        }catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return reminder;
    }
   private static final long serialVersionUID = 1L;
   private Map<Date,String> reminderMap = new HashMap<>();
}