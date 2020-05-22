Car car = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
    car = new Car();
}


@Override
public void onBackPressed() {
    if (car != null) {
        car.drive();
    }
}