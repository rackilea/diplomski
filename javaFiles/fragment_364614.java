public class Appuntamento extends Activity
        { 

        String paziente;
          boolean lun,mar ,mer,giov,ven;
        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.appuntamento);
            //riceviamo id e lo mettiamo come nome utente
            final EditText nomePaziente = (EditText)findViewById(R.id.nomePaziente);
            Bundle dati = this.getIntent().getExtras();
            nomePaziente.setText(dati.getString("id"));
            final String id = dati.getString("id");
            EditText noteAppuntamento = (EditText)findViewById(R.id.noteAppuntamento);
            final String note = noteAppuntamento.getText().toString();

            final CheckBox lunedi = (CheckBox) findViewById(R.id.checkboxLunedi);
           lunedi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

           @Override
           public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
    lun=isChecked;
    //either one above or below
    //lun = lunedi.isChecked();
           }
       }
    );     
            final CheckBox martedi = (CheckBox) findViewById(R.id.checkboxMartedì);
          martedi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

           @Override
           public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
    mar=isChecked;
    //either one above or below
    //mar = martedi.isChecked();
           }
       }
    );     
            final CheckBox mercoledi =(CheckBox)findViewById(R.id.checkboxMercoledi);
             mercoledi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

           @Override
           public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
    mer=isChecked;
    //either one above or below
    // mer = mercoledi.isChecked();
           }
       }
    );     
            final CheckBox giovedi = (CheckBox) findViewById(R.id.checkboxGiovedi);
            giovedi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

           @Override
           public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
     giov=isChecked;
    //either one above or below
    // giov = giovedi.isChecked();
           }
       }
    );     
            final CheckBox venerdi = (CheckBox) findViewById(R.id.checkboxVenerdi); 
    venerdi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

           @Override
           public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
     ven=isChecked;
    //either one above or below
    //ven = venerdi.isChecked();
           }
       }
    );     
            Button richiestaAppuntamento =   (Button)     findViewById(R.id.btnRichiestaAppuntamento);
            richiestaAppuntamento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
              //  ven = venerdi.isChecked();
              //  lun = lunedi.isChecked();
               // mar = martedi.isChecked();
               // mer = mercoledi.isChecked();
              //  giov = giovedi.isChecked();
                StringBuilder testoMail = new StringBuilder();
        //your code this is fine if only one selected item info or data you want to send in mail 
                if (lun ){
                 testoMail.append("Lunedì");
                } else if (mar){
                  testoMail.append("Martedì");
                }else if (mer) {
                 testoMail.append("Mercoledì");
                } else if (giov) {
                 testoMail.append("Giovedì");
                } else if (ven) {
                 testoMail.append("Venerdì");
                }
        // if you want all then comment above code and uncomment below code
        /*
                    if (lun ){
                     testoMail.append("Lunedì");
                    } 
                    if (mar){
                      testoMail.append("Martedì");
                    }
                    if (mer) {
                     testoMail.append("Mercoledì");
                    } 
                    if (giov) {
                     testoMail.append("Giovedì");
                    } 
                    if (ven) {
                     testoMail.append("Venerdì");
                    }
        */

              String giorni = testoMail.toString();
                    Intent mail = new Intent(Intent.ACTION_SEND);
                    mail.setType("message/rfc822");
                    mail.putExtra(Intent.EXTRA_SUBJECT, "Richiesta appuntamento");
                    mail.putExtra(Intent.EXTRA_TEXT, "Nome paziente: " + id + " " + giorni + " " + "Note: " + note);
                    mail.putExtra(Intent.EXTRA_EMAIL, new String[] {"dottcastellitto@gmail.com"});
                    startActivity(mail);
                }
            });

        }
        }