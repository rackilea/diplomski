package test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        Map<CustomKey,String> map = new HashMap<>();

        CustomKey ck = new CustomKey(1, "PartOrderDateRaised_mva_p_");
        map.put(ck, "hello");
        CustomKey ckOne = new CustomKey(15, "PartOrderDateRaised_mva_p_");
        map.put(ckOne, "hello");
        CustomKey ckTwo = new CustomKey(10, "PartOrderDateRaised_mva_p_");
        map.put(ckTwo, "hello");
        CustomKey ckThree = new CustomKey(3, "PartOrderDateRaised_mva_p_");
        map.put(ckThree, "hello");
        CustomKey ckFour = new CustomKey(5, "PartOrderDateRaised_mva_p_");
        map.put(ckFour, "hello");
        CustomKey ckFive = new CustomKey(11, "PartOrderDateRaised_mva_p_");
        map.put(ckFive, "hello");

        ArrayList<CustomKey> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (CustomKey key : keys) {
        System.out.println(key);
    }
    }


}
class CustomKey implements Comparable<CustomKey>{
    Integer codeNumber;
    String codeText;
    public CustomKey(Integer codeNumber, String codeText) {
        this.codeNumber = codeNumber;
        this.codeText = codeText;
    }
    public Integer getCodeNumber() {
        return codeNumber;
    }
    public void setCodeNumber(Integer codeNumber) {
        this.codeNumber = codeNumber;
    }
    public String getCodeText() {
        return codeText;
    }
    public void setCodeText(String codeText) {
        this.codeText = codeText;
    }
    @Override
    public String toString() {
        return this.getCodeText()+this.getCodeNumber(); 
    }
    @Override
    public int compareTo(CustomKey o) {

        return this.getCodeNumber().compareTo(o.getCodeNumber());
    }
}