view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClientesContatosModel md = arrContatos.get(i);


                    Intent in = new Intent(getApplicationContext(),
                            ContatosView.class);


                    in.putExtra("endereco",md.getNome());





                    startActivity(in);

                }
            });