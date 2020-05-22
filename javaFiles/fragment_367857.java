package fireb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Fireb {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FileInputStream serviceAccount;
        FirebaseOptions options = null;
        try {
            serviceAccount = new FileInputStream("C:\\key\\testapp-f0fe2-firebase-adminsdk-4po4a-5ce6c60b81.json");
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://testapp-f0fe2.firebaseio.com")
                    .build();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        FirebaseApp.initializeApp(options);
        String topics = getDatafromFirebase();
        System.out.println(topics);
        System.out.println("Everything right!");
    }

    private static String getDatafromFirebase() {
        CountDownLatch done = new CountDownLatch(1);
        StringBuilder b = new StringBuilder();
        DatabaseReference dbRef = FirebaseDatabase.getInstance()
                .getReference();

        dbRef.child("topics").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // TODO Auto-generated method stub
                if(snapshot.exists()) {
                    for(DataSnapshot s:snapshot.getChildren()) {
                        Topics t = s.getValue(Topics.class);
                        b.append(t.getName());
                        b.append(" ");
                    }
                    done.countDown();
                }
                else {
                    b.append("No existe ");
                    done.countDown();
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // TODO Auto-generated method stub
                b.append("Error: "+error.getDetails());
                done.countDown();
            }
            });
        try {
            done.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return b.toString();
    }
}