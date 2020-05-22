public class Arrivi extends Fragment {

    //ARRIVI
    public String[] A_Compagnia = new String[200];
    public String[] A_CodiceVolo = new String[200];
    public String[] A_Citta = new String[200];
    public String[] A_OraPrevista = new String[200];
    public String[] A_OraStimata = new String[200];
    public String[] A_StatoVolo = new String[200];

    public static Arrivi newInstance(String[] A_Compagnia, String[] A_CodiceVolo, String[] A_Citta, String[] A_OraPrevista, String[] A_OraStimata, String[] A_StatoVolo) {
        Arrivi fragment = new Arrivi();

        Bundle bundle = new Bundle();
        bundle.putStringArray("A_Compagnia", A_Compagnia);
        bundle.putStringArray("A_CodiceVolo", A_CodiceVolo);
        bundle.putStringArray("A_Citta", A_Citta);
        bundle.putStringArray("A_OraPrevista", A_OraPrevista);
        bundle.putStringArray("A_OraStimata", A_OraStimata);
        bundle.putStringArray("A_StatoVolo", A_StatoVolo);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if(bundle != null) {
            this.A_Compagnia = bundle.getStringArray("A_Compagnia");
            this.A_CodiceVolo = bundle.getStringArray("A_CodiceVolo");
            this.A_Citta = bundle.getStringArray("A_Citta");
            this.A_OraPrevista = bundle.getStringArray("A_OraPrevista");
            this.A_OraStimata = bundle.getStringArray("A_OraStimata");
            this.A_StatoVolo = bundle.getStringArray("A_StatoVolo");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.arrivi, container, false);

        return view;
    }
}