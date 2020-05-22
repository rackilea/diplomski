DATA_UNIT_MULTIPLIER=1024
XMX_JVM_VALUE=$(ps -ef | grep -oP "Xmx\d+(m|g)" | sort -rn | cut -d'x' -f2 | head -1)
XMX_DATA_UNIT="${XMX_JVM_VALUE:$((${#XMX_JVM_VALUE}-1)):1}"
XMX_JVM_NUM=$(echo $XMX_JVM_VALUE | sed '$s/.$//')

XMX_SIZE=1
if [ "$XMX_DATA_UNIT" = "m" ]; then
    XMX_SIZE=$(($XMX_JVM_NUM * $DATA_UNIT_MULTIPLIER ))
elif [ "$XMX_DATA_UNIT" = "g" ]; then
    XMX_SIZE=$(($XMX_JVM_NUM * $DATA_UNIT_MULTIPLIER * $DATA_UNIT_MULTIPLIER))
fi