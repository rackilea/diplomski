int withinRange = -1;
   while (lector.hasNext()) {
        linea = lector.nextLine();

        if (linea.contains("Son"))
           withinRange =0;
        if (withinRange == 0) {
            texto.append(linea);
            texto.append("\n");
        }
        if (linea.contains("Niece"))
           withinRange = 1;
   }