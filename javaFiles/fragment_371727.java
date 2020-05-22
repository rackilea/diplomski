Editable nome = name.getText();
   System.out.println(nome);
   Intent intent = new Intent(HelloActivity.this, MainActivity.class);
   intent.putExtra("keyName",nome.toString());
   System.out.println(intent.getExtras());
   startActivity(intent);