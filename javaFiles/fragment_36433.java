public class homeActivity extends AppCompatActivity  {


    private float rateValue;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);


            AlertDialog.Builder mBuild = new AlertDialog.Builder(homeActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.ratingbar,null);

            final RatingBar ratebar = (RatingBar)mView.findViewById(R.id.ratingBar);
            ratebar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    rateValue = rating;
                    Toast.makeText(homeActivity.this, ""+rating, Toast.LENGTH_SHORT).show();
                }
            });

            Button btnSubmit=(Button)mView.findViewById(R.id.btnSubRating);
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(homeActivity.this, ""+rateValue, Toast.LENGTH_SHORT).show();
                }
            });

            mBuild.setView(mView);
            AlertDialog dialog=mBuild.create();
            dialog.show();

}

}