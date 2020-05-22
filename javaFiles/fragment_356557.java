File f=new File("abc.txt"); //Takes the default path, else, you can specify the required path
if(f.exists())
{
    f.delete();
}
f.createNewFile(); 
FileObject destn = VFS.getManager().resolveFile(f.getAbsolutePath());
UserAuthenticator auth = new StaticUserAuthenticator("", "myusername", "secret_password");
FileSystemOptions opts = new FileSystemOptions();

DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);
FileObject fo = VFS.getManager().resolveFile("\\\\192.168.0.1\\direcory\\to\\GetData\\sourceFile.txt",opts);
destn.copyFrom(fo,Selectors.SELECT_SELF);
destn.close();