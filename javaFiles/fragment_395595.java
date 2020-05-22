pos = clip1.getMicrosecondPosition();
System.out.println("pos 1: " + pos);
if( pos == (d + duration[i])){
    System.out.println("posFinal : " + pos);
    clip1.stop();
    break;
}