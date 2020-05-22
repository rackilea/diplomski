update_pid()
{
    JAVA_PID=$(pgrep -f "[A]pacheJMeter.jar $RMI_HOST_DEF -Dserver_port=1099")
}
...
do_restart()
{
     do_stop
     update_pid
     do_start
}