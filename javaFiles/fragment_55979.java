public class MainActivity extends Activity {

    @Override
    protected void onCreate( final Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        this.setContentView( R.layout.activity_main );
        final ColorOptionsView colorOptionsView = ( ColorOptionsView ) this.findViewById( R.id.main_color_options);

    }

}