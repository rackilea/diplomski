public class MainActivity extends ActionBarActivity {       

    private ImageView img;           

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.imageView1); 
        createAndSetRandomImage();                    
    }

    public void createAndSetRandomImage(){
        Random rand = new Random();

        for (int i=0; i<width; i++){
            for (int j=0;  j<height ; j++){
            // default color : Black
            int colorToPut = Color.BLACK;

            // If lucky get a white pixel ;)
            if(rand.nextInt(2)==0){
                colorToPut = Color.WHITE;
            }

            // Set color to (i,j) pixel
            randomGridBitmap.setPixel(i,j,colorToPut);
            }
        }
        imv.setImageBitmap(randomGridBitmap);                        
    }                   
}