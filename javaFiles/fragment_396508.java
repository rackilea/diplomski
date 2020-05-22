import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;

public class JSONObject {
    private int channel;
    private int sf;
    private Date time;
    private String gwip;
    private String gwid;
    private String repeater;
    private int systype;
    private int rssi;
    private double snr;
    private double snr_min;
    private double snr_max;
    private String macAddr;
    private String data;
    private int frameCnt;
    private int fport;

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getSf() {
        return sf;
    }

    public void setSf(int sf) {
        this.sf = sf;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getGwip() {
        return gwip;
    }

    public void setGwip(String gwip) {
        this.gwip = gwip;
    }

    public String getGwid() {
        return gwid;
    }

    public void setGwid(String gwid) {
        this.gwid = gwid;
    }

    public String getRepeater() {
        return repeater;
    }

    public void setRepeater(String repeater) {
        this.repeater = repeater;
    }

    public int getSystype() {
        return systype;
    }

    public void setSystype(int systype) {
        this.systype = systype;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public double getSnr() {
        return snr;
    }

    public void setSnr(double snr) {
        this.snr = snr;
    }

    public double getSnr_min() {
        return snr_min;
    }

    public void setSnr_min(double snr_min) {
        this.snr_min = snr_min;
    }

    public double getSnr_max() {
        return snr_max;
    }

    public void setSnr_max(double snr_max) {
        this.snr_max = snr_max;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getFrameCnt() {
        return frameCnt;
    }

    public void setFrameCnt(int frameCnt) {
        this.frameCnt = frameCnt;
    }

    public int getFport() {
        return fport;
    }

    public void setFport(int fport) {
        this.fport = fport;
    }

    @Override
    public String toString() {
        return "JSONObject{" + "channel=" + channel + ", sf=" + sf + ", time=" + time + ", gwip=" + gwip + ", gwid=" + gwid + ", repeater=" + repeater + ", systype=" + systype + ", rssi=" + rssi + ", snr=" + snr + ", snr_min=" + snr_min + ", snr_max=" + snr_max + ", macAddr=" + macAddr + ", data=" + data + ", frameCnt=" + frameCnt + ", fport=" + fport + '}';
    }

    public static void main(String[] args) throws Exception {
        String json = "{\"channel\":922875000,\"sf\":12,\"time\":\"2019-05-28T16:30:29Z\",\"gwip\":\"192.168.0.180\",\"gwid\":\"00001c497b431ff5\",\"repeater\":\"00000000ffffffff\",\"systype\":170,\"rssi\":-103,\"snr\":20.5,\"snr_max\":33,\"snr_min\":18,\"macAddr\":\"00000000aabb60ba\",\"data\":\"00000000\",\"frameCnt\":8,\"fport\":3}";
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject obj = objectMapper.readValue(json, JSONObject.class);
        System.out.println(obj.toString());
    }
}