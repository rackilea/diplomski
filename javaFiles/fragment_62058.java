private String chiffre = "";

//...

public void yourMethod()
{
    //...
    b.setOnKeyTyped(new EventHandler<KeyEvent>() {
       public void handle(KeyEvent ke) {
         chiffre = ke.getCharacter();
       }
    });
    //...
 }