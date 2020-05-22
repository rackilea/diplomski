public class MainActivity extends AppCompatActivity {

    int numeroHomem = 0;
    int numeroMulher = 0;
    int numeroPessoas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);


      final TextView campoTexto = (TextView) findViewById(R.id.pessoas);
      final Button botaoHomem = (Button) findViewById(R.id.homem);
      final Button botaoMulher = (Button) findViewById(R.id.mulher);
      final Button botaoReset = (Button) findViewById(R.id.reset);

      botaoHomem.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                numeroHomem++;
                numeroPessoas++;
                String mensagem = Integer.toString(numeroPessoas);
                campoTexto.setText("Total: " + mensagem + " pessoas");
                botaoHomem.setText(Integer.toString(numeroHomem));
            }
          });
    }
}