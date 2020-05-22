// Added two lines.
DataLine.Info info = new DataLine.Info( SourceDataLine.class, audioFormat );
SourceDataLine dataLine = (SourceDataLine) AudioSystem.getLine( info );
dataLine.open();
// Adjust the volume on the output line.
if( dataLine.isControlSupported( FloatControl.Type.MASTER_GAIN)) {
    // If inside this if, the Master_Gain must be supported. Yes?
    FloatControl volume = (FloatControl) dataLine.getControl(FloatControl.Type.MASTER_GAIN);
    // This line throws an exception. "Master_Gain not supported"
    volume.setValue( 100.0F );
}