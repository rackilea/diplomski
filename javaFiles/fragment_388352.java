import java.util.ArrayList;
import java.util.List;
class TempVO {
    private int zoneId;
    private int tempId;
    private String tempValue;
    public TempVO(int zoneId, int tempId, String tempValue) {
        super();
        this.zoneId = zoneId;
        this.tempId = tempId;
        this.tempValue = tempValue;
    }
    public int getZoneId() {
        return zoneId;
    }
    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }
    public int getTempId() {
        return tempId;
    }
    public void setTempId(int tempId) {
        this.tempId = tempId;
    }
    public String getTempValue() {
        return tempValue;
    }
    public void setTempValue(String tempValue) {
        this.tempValue = tempValue;
    }
    @Override
    public String toString() {
    return "zonedId: " + this.zoneId + " | tempId: " + this.tempId + " | tempValue: " + this.tempValue;
    }
}
public class Main { 
    public static void main(String[] args) {
        // initialize list
        List<TempVO> tempVOs = new ArrayList<>();
        tempVOs.add(new TempVO(2, 1, "check"));
        tempVOs.add(new TempVO(2, 3, "check"));
        tempVOs.add(new TempVO(2, 4, "check"));
        tempVOs.add(new TempVO(2, 4, "enterd1"));
        tempVOs.add(new TempVO(3, 5, "check"));
        tempVOs.add(new TempVO(3, 8, "primary"));
        tempVOs.add(new TempVO(3, 6, "check"));
        tempVOs.add(new TempVO(3, 8, "check"));
        // only print values wherein interested
        for(int i = 0; i < tempVOs.size(); i++) {
            TempVO outerTempVO = tempVOs.get(i);
            boolean keep = true;
            if("check".equals(outerTempVO.getTempValue())) {
                for(int j = 0; j < tempVOs.size(); j++) {
                    if(i != j) {
                        TempVO innerTempVO = tempVOs.get(j);
                        if(outerTempVO.getTempId() == innerTempVO.getTempId() && outerTempVO.getZoneId() == innerTempVO.getZoneId()) {
                            keep = false;
                            break;
                        }
                    }
                }
            }
            if(keep)
                System.out.println(outerTempVO);
        }
    }
}