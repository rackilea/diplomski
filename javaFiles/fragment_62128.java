public MMAL_PORT_T[] getPorts() {
    Pointer[] array = input.getPointerArray(0, input_num);
    MMAL_PORT_T[] ports = new MMAL_PORT_T[array.length];
    for (int i=0;i < ports.length;i++) {
        ports[i] = new MMAL_PORT_T(array[i]);
    }
    return ports;
}