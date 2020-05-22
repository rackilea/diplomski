this.file = new File(path+"\\"+this.exec_name+".exe");      
ProcessBuilder pb = new ProcessBuilder(this.hmetis_args);
pb.directory(this.file);
                    ^
                    |
                    ++++++++ "C:\hMetis\1.5.3-win32\hmetis.exe"
                             should be "C:\hMetis\1.5.3-win32"