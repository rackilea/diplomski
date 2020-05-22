public class POIExcelReader {

private void setHenAllocKeyHeader(StringBuilder sb) {
    sb.append ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
            + "<NikuDataBus xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"../xsd/nikuxog_customObjectInstance.xsd\">\r\n"
            + "<Header action=\"write\" externalSource=\"NIKU\"objectType=\"customObjectInstance\" version=\"8.1.0.4247\"/>\r\n"
            + "<customObjectInstances objectCode=\"hen_allockey_p\">\r\n"
            + "<instance instanceCode=\"MIG5033028\" objectCode=\"hen_allockey_p\" parentInstanceCode=\"001260\" parentObjectCode=\"project\">\r\n");
}

private void setHenAllocKeyBottom (StringBuilder sb) {
    sb.append ("<OBSAssocs/>\r\n"
            +"<Security/>\r\n"
            +"</customObjectInstances>\r\n" 
            + "</NikuDataBus>\r\n");
}

protected void jobRun() throws Exception {

    StringBuilder sb = new StringBuilder();
    setHenAllocKeyHeader(sb);
    String prolog = sb.toString();

    sb = new StringBuilder();
    setHenAllocKeyBottom(sb);
    String epilog = sb.toString();


    FileOutputStream fos = new FileOutputStream("c:\\test\\osem.xml");
    OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
    osw.write(prolog);
    osw.write(epilog);
    osw.flush();
    osw.close();

}
public static void main(String[] args){
try{
            job.jobRun();
    } catch (Exception e)
    {
        System.out.println("");
    }
}