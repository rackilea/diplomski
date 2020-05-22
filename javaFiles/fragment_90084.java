File archivo = null;
FileWriter fr = null;
try {
    archivo = new File("lista de numeros.txt");
    fr = new FileWriter(archivo, true);
    for (contador = 0; contador < numeros; contador++) {
        array[contador] = Integer.parseInt(JOptionPane.showInputDialog("Ingresa " + numeros + " números"));
        fr.write(Integer.toString(array[contador]));
        fr.write("\r\n");
    } 
} catch (Exception e) {
  System.out.println("Error al escribir");
} finally {
  fr.close();
}