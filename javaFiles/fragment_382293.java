MidiDevice device = /* specify a MIDI device */
MusicTransmitterToSequence transmitter = new MusicTransmitterToSequence(device); 
transmitter.startListening(); 
// Do stuff
transmitter.stopListening(); 
Sequence music = transmitter.getSequence();