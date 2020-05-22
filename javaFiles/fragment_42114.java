class1 {
        class2 frame2 = new class2();
        void login(){
            String x = loginField.getText();
            edu.app.persist.teach ens= new edu.app.persist.teach(x);
            class2.setLogin(x);
        }
   }

   class2 extends JFrame{
       String login;
       String getLogin(){..}
       void setLogin(String s){..}
       .
       .
   }