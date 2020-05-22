VVVV make this echo fail
$ ( r=; echo "foo" ; r=$r$?; echo "bar" 1>&- ; r=$r$? ; echo "baz" ; r=$r$? ; (($r==0)) )
foo
-bash: echo: write error: Bad file descriptor
baz
$ echo $?
1          <--- failure code, but all the commands in the subshell still ran.