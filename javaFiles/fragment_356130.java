sudo dtrace -s /dev/stdin

syscall::open*:entry

{

   printf("%s %s", execname, copyinstr(arg0));

}

<Ctrl-D>