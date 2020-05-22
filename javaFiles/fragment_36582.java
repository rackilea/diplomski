class MyActivity extends AppCompatActivity implements OnCostChangeListener {
//...
  @Override  
  public void onChange(List<Item> list) {
    int sum = 0;
    for (Item it : list) {
      sum += it.getCost();
    }

    ((TextView) findViewById(R.id.totalCost)).setText(String.valueOf(sum));
  }
//...
}