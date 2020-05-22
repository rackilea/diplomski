public class SplashScreen extends Activity  {

    public int thread = 0;

    //ARRIVI
    public String[] A_Compagnia = new String[200];
    public String[] A_CodiceVolo = new String[200];
    public String[] A_Citta = new String[200];
    public String[] A_OraPrevista = new String[200];
    public String[] A_OraStimata = new String[200];
    public String[] A_StatoVolo = new String[200];

    // PARTENZE
    public String[] P_Compagnia = new String[200];
    public String[] P_CodiceVolo = new String[200];
    public String[] P_Citta = new String[200];
    public String[] P_OraPrevista = new String[200];
    public String[] P_OraStimata = new String[200];
    public String[] P_StatoVolo = new String[200];

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splashscreen);

        new FlightTask(this).execute();
    }

    public class FlightTask extends AsyncTask<String, Integer, Boolean> {
        private ProgressDialog prog;
        private boolean result;

        private final WeakReference<Context> contextReference;

        public FlightTask(Context context) {
            this.contextReference = new WeakReference<Context>(context);
        }

        @Override
        protected void onPreExecute() {
            prog = new ProgressDialog(SplashScreen.this);
            prog.setMessage("Connessione in corso...");
            prog.show();
            prog.setCanceledOnTouchOutside(false);
            prog.setCancelable(false);
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                org.jsoup.nodes.Document doc = Jsoup.connect("http://s.eu").timeout(10*1000).get();
                // ARRIVI
                org.jsoup.nodes.Element tabella = doc.getElementsByClass("tabella-voli").first();
                Iterator<org.jsoup.nodes.Element> iterator = tabella.select("td").iterator();

                while(iterator.hasNext()){
                    thread++;

                    A_Compagnia[thread] = iterator.next().text();
                    A_CodiceVolo[thread] = iterator.next().text();
                    A_Citta[thread] = iterator.next().text();
                    A_OraPrevista[thread] = iterator.next().text();
                    A_OraStimata[thread] = iterator.next().text();
                    A_StatoVolo[thread] = iterator.next().text();
                    System.out.println("THREAD ARRIVI: "+A_StatoVolo[thread]);
                }

                // PARTENZE
                org.jsoup.nodes.Element tabella2 = doc.getElementsByClass("tabella-voli").get(1);
                Iterator<org.jsoup.nodes.Element> iterator2 = tabella2.select("td").iterator();

                thread = 0;

                while(iterator2.hasNext()){
                    thread++;

                    P_Compagnia[thread] = iterator2.next().text();
                    P_CodiceVolo[thread] = iterator2.next().text();
                    P_Citta[thread] = iterator2.next().text();
                    P_OraPrevista[thread] = iterator2.next().text();
                    P_OraStimata[thread] = iterator2.next().text();
                    P_StatoVolo[thread] = iterator2.next().text();
                    System.out.println("THREAD PARTENZE: "+P_Citta[thread]);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(!result) {
                return;
            }

            Context context = this.contextReference.get();
            if(context != null) {
                prog.dismiss();

                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("A_Compagnia", A_Compagnia);
                intent.putExtra("A_CodiceVolo", A_CodiceVolo);
                intent.putExtra("A_Citta", A_Citta);
                intent.putExtra("A_OraPrevista", A_OraPrevista);
                intent.putExtra("A_OraStimata", A_OraStimata);
                intent.putExtra("A_StatoVolo", A_StatoVolo);
                intent.putExtra("P_Compagnia", P_Compagnia);
                intent.putExtra("P_CodiceVolo", P_CodiceVolo);
                intent.putExtra("P_Citta", P_Citta);
                intent.putExtra("P_OraPrevista", P_OraPrevista);
                intent.putExtra("P_OraStimata", P_OraStimata);
                intent.putExtra("P_StatoVolo", P_StatoVolo);
                context.startActivity(intent);
            }
        }
    }
}