public static void main(String[] args) {

    List<FileTransAuditInfo> workRequestFileTransAuditList = new ArrayList<>();

    final String type1 = "type 1";
    final String type2 = "type 2";

    List<FileTransAuditInfo> workRequestFileTransAuditListforSubmission = workRequestFileTransAuditList.stream()
            .filter(file -> file.getFileEventType().equalsIgnoreCase(type1) || file.getFileEventType().equalsIgnoreCase(type2)) 
            .collect(Collectors.toList());

}