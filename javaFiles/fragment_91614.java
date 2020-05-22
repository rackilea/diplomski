public class StreetClass {
    private String id;
    private String semail;
    private String sname;
    private String stype;
    private String sdetail;
    private String slocation;
    private String sdate;
    private String imgurl;

    public StreetClass(){}

    public StreetClass(String id, String semail, String sname, String stype, String sdetail, String slocation, String sdate, String imgurl) {
        this.id = id;
        this.semail = semail;
        this.sname = sname;
        this.stype = stype;
        this.sdetail = sdetail;
        this.slocation = slocation;
        this.sdate = sdate;
        this.imgurl = imgurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getSdetail() {
        return sdetail;
    }

    public void setSdetail(String sdetail) {
        this.sdetail = sdetail;
    }

    public String getSlocation() {
        return slocation;
    }

    public void setSlocation(String slocation) {
        this.slocation = slocation;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}