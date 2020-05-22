import android.Manifest;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.pm.PackageManager;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Build;
        import android.os.Environment;
        import android.support.annotation.NonNull;
        import android.support.design.widget.NavigationView;
        import android.support.design.widget.TabLayout;
        import android.support.v4.app.ActivityCompat;
        import android.support.v4.content.ContextCompat;
        import android.support.v4.view.ViewPager;
        import android.support.v4.widget.DrawerLayout;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.Toast;
        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.util.ArrayList;
        import farmani.com.essentialwordsforielts.R;

public class MainActivity extends AppCompatActivity {

    public static Context context;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView hamburger;
    SQLiteDatabase database;
    String destPath;

    public static ArrayList<Structure> list = new ArrayList<Structure>();
    public static ArrayList<Structure> favorite = new ArrayList<Structure>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity_main);

        if(Build.VERSION.SDK_INT >= 23){


            if(ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(MainActivity.this
                        , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE
                                ,Manifest.permission.WRITE_EXTERNAL_STORAGE}
                        , 1);

            }else if(ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(MainActivity.this
                        , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE
                                ,Manifest.permission.WRITE_EXTERNAL_STORAGE}
                        , 1);

            }else {

                Toast.makeText(MainActivity.this,"You grandet 
                        earlier",Toast.LENGTH_LONG).show();

            }


        }

        context = getApplicationContext();
        setTabOption();

        drawerLayout = findViewById(R.id.navigation_drawer);
        navigationView = findViewById(R.id.navigation_view);
        hamburger = findViewById(R.id.hamburger);
        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });







    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {

                if (grantResults.length >= 2 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED && grantResults[1] ==
                        PackageManager.PERMISSION_GRANTED) {

                   setupDB();
                   setupNavDrawer();

                    Toast.makeText(MainActivity.this, "Access granted",
                            Toast.LENGTH_LONG).show();

                }

            }
        }
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START);
        } else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                    MainActivity.this);

            alertDialog.setTitle(R.string.exit);

            alertDialog.setMessage(R.string.exit_ask);
            alertDialog.setCancelable(false);

            alertDialog.setPositiveButton(R.string.yes,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

            alertDialog.setNegativeButton(R.string.no,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                        }
                    });

            alertDialog.show();
        }
    }


    private void setTabOption() {
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new AdapterFragment(getSupportFragmentManager(),
                context));
        TabLayout tabStrip = findViewById(R.id.tabs);
        tabStrip.setupWithViewPager(viewPager);
    }

    private void setupDB(){
        try {
            destPath =
                    Environment.getExternalStorageDirectory().getAbsolutePath() + "/ielts/";
            File file = new File(destPath);
            if (!file.exists()) {
                file.mkdirs();
                file.createNewFile();
                CopyDB(getBaseContext().getAssets().open("md_book.db"),
                        new FileOutputStream(destPath + "/md_book.db"));
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    private void setupNavDrawer(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.exit) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                            MainActivity.this);

                    alertDialog.setTitle(R.string.exit);

                    alertDialog.setMessage(R.string.exit_ask);
                    alertDialog.setCancelable(false);

                    alertDialog.setPositiveButton(R.string.yes,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int
                                        which) {
                                    finish();
                                }
                            });

                    alertDialog.setNegativeButton(R.string.no,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int
                                        which) {

                                    dialog.cancel();
                                }
                            });

                    alertDialog.show();
                }

                return true;
            }
        });

        selectList();
        selectFavorite();
    }

    private void CopyDB(InputStream inputStream, OutputStream outputStream)
            throws IOException {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }

    private void selectFavorite(){

        database = SQLiteDatabase.openOrCreateDatabase(destPath + "/md_book.db",
                null);
        Cursor cursor = database.rawQuery("SELECT * FROM main WHERE fav = 1",
                null);
        while (cursor.moveToNext()){
            String word = cursor.getString(cursor.getColumnIndex("word"));
            String definition =
                    cursor.getString(cursor.getColumnIndex("definition"));
            String trans = cursor.getString(cursor.getColumnIndex("trans"));
            String img = cursor.getString(cursor.getColumnIndex("img"));
            int id = cursor.getInt(cursor.getColumnIndex("id"));

            Structure struct = new Structure(word, definition, trans, img, id);
            struct.setWord(word);
            struct.setDefinition(definition);
            struct.setTrans(trans);
            struct.setImg(img);
            struct.setId(id);
            favorite.add(struct);
        }

    }

    private void selectList(){

        database = SQLiteDatabase.openOrCreateDatabase(destPath + "/md_book.db",
                null);
        Cursor cursor = database.rawQuery("SELECT * FROM main", null);
        while (cursor.moveToNext()){
            String word = cursor.getString(cursor.getColumnIndex("word"));
            String definition =
                    cursor.getString(cursor.getColumnIndex("definition"));
            String trans = cursor.getString(cursor.getColumnIndex("trans"));
            String img = cursor.getString(cursor.getColumnIndex("img"));
            int id = cursor.getInt(cursor.getColumnIndex("id"));

            Structure struct = new Structure(word, definition, trans, img, id);
            struct.setWord(word);
            struct.setDefinition(definition);
            struct.setTrans(trans);
            struct.setImg(img);
            struct.setId(id);
            list.add(struct);
        }

    }

}