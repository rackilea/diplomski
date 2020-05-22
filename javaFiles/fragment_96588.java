private int randomNum;

private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {                                            

    randomNum = (int)(Math.random()*palavras.length);
    System.out.println(""+randomNum);


    jLabelRandom.setText(Introduce words that begins with : " + palavras[randomNum]);


}                                           

private void jButtonVerificarActionPerformed(java.awt.event.ActionEvent evt) {                                                 

    int certas = 0;

    String[] words = {jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(),
                      jTextField4.getText()};         

    for (String w : words){

        if(w.startsWith(Integer.ToString(palavras[randomNum]))){ // This variable can't be shared here, but I need it here :)
            certas++;
        }
}

     jLabelCertas.setText(Integer.toString(certas));
     words = null;

}                                                

public String[] palavras = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};