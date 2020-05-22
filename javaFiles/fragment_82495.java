@Override
public void onClick(DialogInterface dialogInterface, int i) {
  final Context context = getContext();
  autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
  FirebaseUser usuario = autenticacao.getCurrentUser();

  suario.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
    @Override
    public void onComplete(@NonNull Task<Void> task) {
      if (task.isSuccessful()) {
        Toast.makeText(context, "E-mail de redefinição de senha enviado!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(context, IntroActivity.class);
        startActivity(intent);

      } else {
        Toast.makeText(context, "Ocorreu um erro na exclusão da sua conta", Toast.LENGTH_SHORT).show();
      }
    }
  });