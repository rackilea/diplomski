// capitalize class name
public class Login extends javax.swing.JFrame {
   // create one instance only of Welc:
   public Welc welc = new Welc();  //!! added

   // ....


   private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) {

      // .... code deleted for simplicfication

            if (trig == 1) {
               JOptionPane.showMessageDialog(null,
                     "YOU ARE LOGGED IN AS AN ADMIN!");
               // !! Welc spark = new Welc(); // removed 
               // spark.btn_create.setVisible(false);
               welc.btnCreateSetVisible(false); //!! add this
            } else {
               JOptionPane.showMessageDialog(null,
                     "YOU ARE LOGGED IN AS A STUDENT!");
            }
            JOptionPane.showMessageDialog(null, "Connection Established!");
            this.dispose();
            //!! new Welc().setVisible(true);
            welc.setVisible(true);
         } 
      } catch (Exception e) {
         //!! never have empty catch blocks
      }
   }


   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
      //!! never use deprecated methods
      jPanel1.show();
      jPanel2.hide();
      jLabel2.setText("USERNAME:");
      trig = 1;
   }

// ....