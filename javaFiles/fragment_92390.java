Microsoft.Win32.RegistryKey rKey = Microsoft.Win32Registry.CurrentUser;
Microsoft.Win32.RegistryKey key = rKey.OpenSubKey(@"Software\Microsoft\Windows\CurrentVersion\Explorer\User Shell Folders",
true); 
string favoriteFolderPath = key.GetValue("Favorites").ToString();
string myFolder           = "MyFolder";
myFolder                  = Path.Combine(favoriteFolderPath, myFolder);

try
{
    // If the directory doesn't exist, create it.
    if (!Directory.Exists(myFolder))
    {
        Directory.CreateDirectory(myFolder);
    }
}
catch (Exception)
{
  //Could not create Directory
}