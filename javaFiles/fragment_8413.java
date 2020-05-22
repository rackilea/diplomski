public class VoipBlock {

     private int packetNumber;
     private String type;

     public int getPacketNumber() {
      return packetNumber;
     }

     public String getType() {
      return type;
     }

     public void setPacketNumber(int value) {
       packetNumber = value;
     } 

     public void setType(String value) {
       type = value
     }

     public VoipBlock clone() {
        VoipBlock clone = VoipBlock();
        clone.setType(this.getType());
        clone.setPacketNumber(this.getPacketNumber());
        return clone;
     }

}