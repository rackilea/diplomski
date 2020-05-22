$ (r=;s(){ r=$r$?;}; echo "foo" ; s; echo "bar" 1>&-; s; echo "baz" ; s; (($r==0)) )
foo
-bash: echo: write error: Bad file descriptor
baz
$ echo $?
1