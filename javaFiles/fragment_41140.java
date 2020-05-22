serialPort.openPort();
...
// start sending AT^SCFG?
serialPort.writeBytes("AT^SCFG?\r");
do {
    line = readLine(serialPort);
} while (! is_final_result_code(line))
// Sending of AT^SCFG? command finished (successfully or not)
...
serialPort.closePort();