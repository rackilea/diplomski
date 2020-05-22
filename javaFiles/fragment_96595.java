public class AnkoComponentActivity extends AppCompatActivity {

    public void onCreate(Bundle sis){
        super.onCreate(sis);
        AnkoComponent<AnkoComponentActivity> component = (AnkoComponent<AnkoComponentActivity>) getIntent().getSerializableExtra("uiComponent");
        org.jetbrains.anko.AnkoContextKt.setContentView(component, this);//For reference, this is how you call Kotlin extension functions from Java
    }
}