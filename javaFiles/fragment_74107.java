public Double getGyro_X() {
    if (this.gyro_X == null) {
        Toast.makeText(this, ""+gyro_XIsNullText, ToastdurationShort).show();
        return null;
        //Or maybe: throw new NullPointerException();
    } else { 
    return this.gyro_X;
    }
}