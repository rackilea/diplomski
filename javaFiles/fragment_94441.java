import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.UserGroupInformation;

public class KerberosHDFSIO {

public static void main(String[] args) throws IOException {

    Configuration conf = new Configuration();
    //The following property is enough for a non-kerberized setup
    //      conf.set("fs.defaultFS", "localhost:9000");

    //need following set of properties to access a kerberized cluster
    conf.set("fs.defaultFS", "hdfs://devha:8020");
    conf.set("hadoop.security.authentication", "kerberos");

    //The location of krb5.conf file needs to be provided in the VM arguments for the JVM
    //-Djava.security.krb5.conf=/Users/user/Desktop/utils/cluster/dev/krb5.conf

    UserGroupInformation.setConfiguration(conf);
    UserGroupInformation.loginUserFromKeytab("user@HADOOP_DEV.ABC.COM",
            "/Users/user/Desktop/utils/cluster/dev/.user.keytab");

    try (FileSystem fs = FileSystem.get(conf);) {
        FileStatus[] fileStatuses = fs.listStatus(new Path("/user/username/dropoff"));
        for (FileStatus fileStatus : fileStatuses) {
            System.out.println(fileStatus.getPath().getName());
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}