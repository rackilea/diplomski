int choice; // member field

protected void onCreate(Bundle savedInstanceState) {
    . . .
    hello.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            choice = 1; // no "int" declaration
        }
    });
}

// later inside some method:
    if (choice == 1) {
        // do stuff here
    }