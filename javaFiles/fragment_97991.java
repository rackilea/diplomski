FileInfo fi = new FileInfo(directory);
//directory is the directory where the file is
//and the path is the whole path to the file, including the directory
if (File.Exists(path))
{
   //start the file
   System.Diagnostics.Process.Start(path);
}
else
   MessageBox.Show("Sorry, the file cannot be found.");