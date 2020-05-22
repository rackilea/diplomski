-d directory
            Set the destination directory for class files. The destination
            directory must already exist; javac will not create the desti‐
            nation directory. If a class is part of a package, javac  puts
            the  class file in a subdirectory reflecting the package name,
            creating directories as needed. For example, if you specify -d
            /home/myclasses and the class is called com.mypackage.MyClass,
            then the  class  file  is  called  /home/myclasses/com/mypack‐
            age/MyClass.class.

         If  -d  is  not  specified, javac puts the class file in the same
         directory as the source file.

         Note:   The directory specified by -d is not automatically  added
         to your user class path.