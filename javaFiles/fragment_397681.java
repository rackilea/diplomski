import java.util.List;

public class DataTableObject {

String sPaginationType = "";
String sDom = "";
boolean bProcessing = false;
boolean bServerSide = false;
String sEcho;
int iTotalRecords;
private List<Object> aoColumns;
List<Object> aaData;

public String getsPaginationType() {
    return sPaginationType;
}

public void setsPaginationType(String sPaginationType) {
    this.sPaginationType = sPaginationType;
}

public String getsDom() {
    return sDom;
}

public void setsDom(String sDom) {
    this.sDom = sDom;
}

public boolean isbProcessing() {
    return bProcessing;
}

public void setbProcessing(boolean bProcessing) {
    this.bProcessing = bProcessing;
}

public boolean isbServerSide() {
    return bServerSide;
}

public void setbServerSide(boolean bServerSide) {
    this.bServerSide = bServerSide;
}

public int getiTotalRecords() {
    return iTotalRecords;
}

public void setiTotalRecords(int iTotalRecords) {
    this.iTotalRecords = iTotalRecords;
}

public String getsEcho() {
    return sEcho;
}

public void setsEcho(String sEcho) {
    this.sEcho = sEcho;
}

public List<Object> getAaData() {
    return aaData;
}

public void setAaData(List<Object> aaData) {
    this.aaData = aaData;
}

public List<Object> getAoColumns() {
    return aoColumns;
}

public void setAoColumns(List<Object> aoColumns) {
    this.aoColumns = aoColumns;
}
}