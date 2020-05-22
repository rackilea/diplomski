long position = 0;
if( sequencer.getMicrosecondPosition() != null ) {
    position = sequencer.getMicrosecondPosition();
}

System.out.println("sec" + position/1000000);