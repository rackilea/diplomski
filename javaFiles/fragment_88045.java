import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.sshd.SshServer;
import org.apache.sshd.common.NamedFactory;
import org.apache.sshd.common.file.virtualfs.VirtualFileSystemFactory;
import org.apache.sshd.server.Command;
import org.apache.sshd.server.PasswordAuthenticator;
import org.apache.sshd.server.UserAuth;
import org.apache.sshd.server.auth.UserAuthPassword;
import org.apache.sshd.server.command.ScpCommandFactory;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.session.ServerSession;
import org.apache.sshd.server.sftp.SftpSubsystem;

public class Test {

    public static void main(String args[]) {
        try {
            Runtime.getRuntime().exec("sudo fuser -k " + "2222" + "/tcp");
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

        File TEST = new File("test");
        File ADMIN = new File("admin");
        File ERROR = new File("error");

        TEST.mkdirs();
        ADMIN.mkdirs();
        ERROR.mkdirs();

        SshServer sshServer = SshServer.setUpDefaultServer();
        sshServer.setFileSystemFactory(new VirtualFileSystemFactory(ERROR.getAbsolutePath()));
        sshServer.setPort(2222);
        sshServer.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(new File("my.pem").getAbsolutePath()));
        sshServer.setCommandFactory(new ScpCommandFactory());
        List<NamedFactory<UserAuth>> userAuthFactories = new ArrayList<>();
        userAuthFactories.add(new UserAuthPassword.Factory());
        sshServer.setUserAuthFactories(userAuthFactories);
        sshServer.setPasswordAuthenticator(new PasswordAuthenticator() {
            @Override
            public boolean authenticate(String username, String password, ServerSession session) {
                if ((username.equals("test")) && (password.equals("test"))) {
                    sshServer.setFileSystemFactory(new VirtualFileSystemFactory(TEST.getAbsolutePath()));
                    return true;
                }
                if ((username.equals("admin")) && (password.equals("admin"))) {
                    sshServer.setFileSystemFactory(new VirtualFileSystemFactory(ADMIN.getAbsolutePath()));
                    return true;
                }
                return false;
            }
        });
        List<NamedFactory<Command>> namedFactoryList = new ArrayList<>();
        namedFactoryList.add(new SftpSubsystem.Factory());
        sshServer.setSubsystemFactories(namedFactoryList);
        try {
            sshServer.start();
        } catch (IOException ex) {
            Logger.getLogger(CarrierSFTPServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}