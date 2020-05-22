import  org.apache.commons.lang.StringUtils;

public class ProjectData {
    public List <String> srNumbers;
    public String comments;

    public String getSrNumbersJoined() {
        return StringUtils.join(srNumbers, ",");
    }
}