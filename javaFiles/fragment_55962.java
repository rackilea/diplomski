import java.awt.*;
import java.awt.event.*;
import java.security.Permission;

/** NoExit demonstrates how to prevent 'child'
applications from ending the VM with a call
to System.exit(0).
@author Andrew Thompson */
public class NoExit extends Frame implements ActionListener {

  Button frameLaunch = new Button("Frame"),
     exitLaunch = new Button("Exit");

  /** Stores a reference to the original security manager. */
  ExitManager sm;

  public NoExit() {
     super("Launcher Application");

     sm = new ExitManager( System.getSecurityManager() );
     System.setSecurityManager(sm);

     setLayout(new GridLayout(0,1));

     frameLaunch.addActionListener(this);
     exitLaunch.addActionListener(this);

     add( frameLaunch );
     add( exitLaunch );

     pack();
     setSize( getPreferredSize() );
  }

  public void actionPerformed(ActionEvent ae) {
     if ( ae.getSource()==frameLaunch ) {
        TargetFrame tf = new TargetFrame();
     } else {
        // change back to the standard SM that allows exit.
        System.setSecurityManager(
           sm.getOriginalSecurityManager() );
        // exit the VM when *we* want
        System.exit(0);
     }
  }

  public static void main(String[] args) {
     NoExit ne = new NoExit();
     ne.setVisible(true);
  }
}

/** This example frame attempts to System.exit(0)
on closing, we must prevent it from doing so. */
class TargetFrame extends Frame {
  static int x=0, y=0;

  TargetFrame() {
     super("Close Me!");
     add(new Label("Hi!"));

     addWindowListener( new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
           System.out.println("Bye!");
           System.exit(0);
        }
     });

     pack();
     setSize( getPreferredSize() );
     setLocation(++x*10,++y*10);
     setVisible(true);
  }
}

/** Our custom ExitManager does not allow the VM
to exit, but does allow itself to be replaced by
the original security manager.
@author Andrew Thompson */
class ExitManager extends SecurityManager {

  SecurityManager original;

  ExitManager(SecurityManager original) {
     this.original = original;
  }

  /** Deny permission to exit the VM. */
   public void checkExit(int status) {
     throw( new SecurityException() );
  }

  /** Allow this security manager to be replaced,
  if fact, allow pretty much everything. */
  public void checkPermission(Permission perm) {
  }

  public SecurityManager getOriginalSecurityManager() {
     return original;
  }
}