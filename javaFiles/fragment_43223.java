$  ( r=; echo "foo" ; r=$r$?; echo "bar" ; r=$r$? ; echo "baz" ; r=$r$? ; (($r==0)) )
foo
bar
baz
$ echo $?
0          <--- all the commands in the subshell worked OK, so the status is OK