import java.security.InvalidKeyException;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

public class UserAuthKI{
  public static void main(String[] arg){

try{
  JSch jsch=new JSch();

  String host="";
  String user="";

  Session session=jsch.getSession(user, host, 22);

  // username and passphrase will be given via UserInfo interface.
  UserInfo ui=new MyUserInfo();
  session.setUserInfo(ui);
  session.connect();

  Channel channel =session.openChannel("exec");
  ((ChannelExec)channel).setCommand("echo 'hello'");

  channel.setInputStream(System.in);
  channel.setOutputStream(System.out);

  channel.connect();

}
catch(Exception e){
  System.out.println(e);
}
  }

  public static class MyUserInfo implements UserInfo, UIKeyboardInteractive{
public String getPassword(){ return "passwordHere"; }
public boolean promptYesNo(String str){
    return true;
}

public String getPassphrase(){return null;}
public boolean promptPassphrase(String message){ return false; }
public boolean promptPassword(String message){
    return true;
}
public void showMessage(String message){
  System.out.println(message);
}

public String[] promptKeyboardInteractive(String destination,
                                          String name,
                                          String instruction,
                                          String[] prompt,
                                          boolean[] echo){

    System.out.println("destination: "+destination);
    System.out.println("name: "+name);
    System.out.println("instruction: "+instruction);
    System.out.println("prompt.length: "+prompt.length); 

    String[] str = new String[1];

    if(prompt[0].contains("Password:")){
        str[0] = getPassword();
    }
    else if(prompt[0].contains("Verification code: ")){
        try {
            str[0] = PasswordUtils.verify_code("CODEHERE");
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    else{
        str = null;
    }

    return str;

  }
  }
}