#!/sbin/busybox sh

BUSYBOX="/sbin/busybox"

echo "Remount /system-partition to rw"
mount -o remount,rw /system

if [ -e /sdcard/bootanimation.zip ] ; then
    echo "copy bootanimation"
    $BUSYBOX cp -fp "/sdcard/bootanimation.zip" "/system/media/bootanimation.zip"
    chmod 777 "/system/media/bootanimation.zip"
    chown 0.0 "/system/media/bootanimation.zip"
    $BUSYBOX rm "/sdcard/bootanimation.zip"
else
    echo "Bootanimation not in /sdcard/-folder"
fi