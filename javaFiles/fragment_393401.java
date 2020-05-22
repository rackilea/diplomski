public static class PlaceholderFragment extends Fragment {
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                    Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_calc_simples, container, false);

    etNum1 = (EditText) rootView.findViewById(R.id.etNumero1);
    etNum2 = (EditText) rootView.findViewById(R.id.etNumero2);
    etResultado = (EditText) rootView.findViewById(R.id.etResultado);
    btSomar = (Button) rootView.findViewById(R.id.btSoma);

    btSomar.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            resultado = num1 + num2;
            etResultado.setText(String.valueOf(resultado));
        }
    });
    return rootView;
    }