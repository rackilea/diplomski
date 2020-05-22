BufferedReader fin =new BufferedReader(
              new InputStreamReader(
                      new FileInputStream(f)));
      String texto = fin.readLine();
      fin.close();

      textohere.setText(texto);