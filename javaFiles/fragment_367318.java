// Texto que aparecerá na barra de status (chamada para a notificação)
final String tickerText = "Você recebeu uma mensagem.";

// Detalhes da notificação
final CharSequence titulo = "André";
final CharSequence mensagem = "Exemplo de notificação";

// Current Context
final Context context = this;

//Começar a Brincar AQUI!
btnNotifica = (Button) findViewById(R.id.button1);

btnNotifica.setOnClickListener(new Button.OnClickListener() {
    public void onClick(View v) {
        criarNotificacao(context, tickerText, titulo, mensagem, NotificationReceiverActivity.class);
    }
});