final List<Pecas> pecas = pecasDAO.pegarPecas();
for (Pecas pecasVerificacao : pecasList) {
    for (Pecas pecasBanco : pecas) {
         ...
    }
}