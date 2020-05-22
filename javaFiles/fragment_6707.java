final Button goliButton = new Button(this);  // <---
    goliButton.setText("+");
    goliButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent i = new Intent(TekmaLive.this,DodajStrel.class);
            i.putExtra("MINUTA", currTime /1000 + cetrtina * 15 * 60);
            i.putExtra("TEKMA", tekmaId);
            i.putExtra("IGRALKA", Integer.parseInt(igralka[0]));
            i.putExtra("GOL", true);
            TekmaLive.this.pressedButton = goliButton;  // <---
            TekmaLive.this.startActivityForResult(i, YOUR_REQUEST_CODE);  // <---
        }
    });