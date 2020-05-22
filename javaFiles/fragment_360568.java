/**
* @since 3.0.0
*/
public void setSndHWM (long sndHWM) {
    if (ZMQ.version_full() < ZMQ.make_version(3, 0, 0))
        return;

    setLongSockopt (SNDHWM, sndHWM);
}