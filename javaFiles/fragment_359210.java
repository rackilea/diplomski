public class RoadLinkRecord {
    private final int recordNumber;
    private final String roadlink_fid;
    private final String version;
    private final String versiondate;
    private final String changedate;
    private final String reasonforchange;
    private final String descriptivegroup;
    private final String descriptiveterm;
    private final String natureofroad;
    private final String length;
    private final String directednode_href;
    private final String directednode_orientation;
    private final String directednode_gradeseparation;
    private final String referencetotopographicarea_href;
    private final String theme;
    private final String filename;
    private final String wkb_geometry;
    private final String roadnumber;
    private final String dftname;
    private final String fid;
    private final String roadname;

    public RoadLinkRecord(final int recordNumber, final String[] csvFields) {
        if (csvFields.length != 20) {
            throw new IllegalArgumentException(
                    "Wrong number of fields for a RoadLinkRecord! Expected 20, found "
                            + csvFields.length);
        }
        this.recordNumber = recordNumber;

        this.roadlink_fid = processStringField(csvFields[0]);
        this.version = processStringField(csvFields[1]);
        this.versiondate = processStringField(csvFields[2]);
        this.changedate = processStringField(csvFields[3]);
        this.reasonforchange = processStringField(csvFields[4]);
        this.descriptivegroup = processStringField(csvFields[5]);
        this.descriptiveterm = processStringField(csvFields[6]);
        this.natureofroad = processStringField(csvFields[7]);
        this.length = processStringField(csvFields[8]);
        this.directednode_href = processStringField(csvFields[9]);
        this.directednode_orientation = processStringField(csvFields[10]);
        this.directednode_gradeseparation = processStringField(csvFields[11]);
        this.referencetotopographicarea_href = processStringField(csvFields[12]);
        this.theme = processStringField(csvFields[13]);
        this.filename = processStringField(csvFields[14]);
        this.wkb_geometry = processStringField(csvFields[15]);
        this.roadnumber = processStringField(csvFields[16]);
        this.dftname = processStringField(csvFields[17]);
        this.fid = processStringField(csvFields[18]);
        this.roadname = processStringField(csvFields[19]);
    }

    private static String processStringField(String field) {
        // consider empty fields as null
        if (field.isEmpty()) {
            return null;
        }
        // strip double quotes and replace any escaped quotes
        final int endIndex = field.length() - 1;
        if (field.charAt(0) == '"' && field.charAt(endIndex) == '"') {
            return field.substring(1, endIndex).replace("\"\"", "\"");
        }
        return field;
    }

    public int getRecordNumber() { return recordNumber; }
    public String getRoadlink_fid() { return roadlink_fid; }
    public String getVersion() { return version; }
    public String getVersiondate() { return versiondate; }
    public String getChangedate() { return changedate; }
    public String getReasonforchange() { return reasonforchange; }
    public String getDescriptivegroup() { return descriptivegroup; }
    public String getDescriptiveterm() { return descriptiveterm; }
    public String getNatureofroad() { return natureofroad; }
    public String getLength() { return length; }
    public String getDirectednode_href() { return directednode_href; }
    public String getDirectednode_orientation() { return directednode_orientation; }
    public String getDirectednode_gradeseparation() { return directednode_gradeseparation; }
    public String getReferencetotopographicarea_href() { return referencetotopographicarea_href; }
    public String getTheme() { return theme; }
    public String getFilename() { return filename; }
    public String getWkb_geometry() {     return wkb_geometry; }
    public String getRoadnumber() { return roadnumber; }
    public String getDftname() { return dftname; }
    public String getFid() { return fid; }
    public String getRoadname() { return roadname; }

    @Override
    public String toString() {
        return "roadlink_fid= " + roadlink_fid + "; version= " + version + "; versiondate= "
                + versiondate + "; changedate= " + changedate + "; reasonforchange= "
                + reasonforchange + "; descriptivegroup= " + descriptivegroup + "; descriptiveterm= "
                + descriptiveterm + "; natureofroad= " + natureofroad + "; length= " + length
                + "; directednode_href= " + directednode_href + "; directednode_orientation= "
                + directednode_orientation + "; directednode_gradeseparation= "
                + directednode_gradeseparation + "; referencetotopographicarea_href= "
                + referencetotopographicarea_href + "; theme= " + theme + "; filename= " + filename
                + "; wkb_geometry= " + wkb_geometry + "; roadnumber= " + roadnumber + "; dftname= "
                + dftname + "; fid= " + fid + "; roadname= " + roadname + ";";
    }
}