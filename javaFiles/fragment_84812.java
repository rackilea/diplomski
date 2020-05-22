FREENECTAPI void freenect_select_subdevices(freenect_context *ctx, freenect_device_flags subdevs) {
ctx->enabled_subdevices = (freenect_device_flags)(subdevs & (FREENECT_DEVICE_MOTOR | FREENECT_DEVICE_CAMERA
#ifdef BUILD_AUDIO
        | FREENECT_DEVICE_AUDIO
#endif
        ));
}