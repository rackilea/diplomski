public class TempActivity extends AppCompatActivity implements RateAdapter.RadioClickListener {
...

@Override
public void radioClicked(int position, int rate){
    rates.get(position).setRate(rate);
}