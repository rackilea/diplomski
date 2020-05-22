# Provide user environmental variables to the sudo environment
function sudo_env() {
    userid="$(logname 2>/dev/null || echo $SUDO_USER)"
    pid=$(ps aux |grep "^$userid" |grep "dbus-daemon" | grep "unix:" |awk '{print $2}')
    # Replace null delimiters with newline for grep
    envt=$(cat "/proc/$pid/environ" |tr '\0' '\n')

    # List of environmental variables to use; adjust as needed
    # UPSTART_SESSION must come before GNOME_DESKTOP_SESSION_ID
    exports=( "UPSTART_SESSION" "DISPLAY" "DBUS_SESSION_BUS_ADDRESS" "XDG_CURRENT_DESKTOP" "GNOME_DESKTOP_SESSION_ID" )

    for i in "${exports[@]}"; do
        # Re-set the variable within this session by name
        # Careful, this technique won't yet work with spaces
        if echo "$envt" | grep "^$i=" > /dev/null 2>&1; then
            eval "$(echo "$envt" | grep "^$i=")" > /dev/null 2>&1
            export $i > /dev/null 2>&1
        elif initctl --user get-env $i > /dev/null 2>&1; then
            eval "$i=$(initctl --user get-env $i)" > /dev/null 2>&1
            export $i > /dev/null 2>&1
        fi

        echo "$i=${!i}"
    done
}