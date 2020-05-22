private void verifyActivity(Activity classe, int position) {
            if (position == 1) {
                // HERE I AM TRYING USING DIFFERENT FORMS TO START THE ACTITIVIES
                classe.startActivity(new Intent(classe, PedidosActivity.class));
            }
            if (position == 3) {
                classe.startActivity(new Intent(classe, ChatActivity.class));
            }
            if (position == 5) {
                classe.startActivity(new Intent(classe, GruposActivity.class));
            }
            if (position == 7) {
                classe.startActivity(new Intent(classe, PerfilActivity.class));
            }
            if (position == 9) {
                classe.startActivity(new Intent(classe, SobreActivity.class));
            }