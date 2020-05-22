response.setHeader("Content-Disposition", "attachment;filename="+***Your zip filename***);
response.setContentType("application/zip");
response.setHeader("Expires", "0");
response.setHeader("Cache-Control", "must-revalidate, postcheck=0, pre-check=0");
response.setHeader("Pragma", "public");

ServletOutputStream out = response.getOutputStream();
ZipOutputStream zout = new ZipOutputStream(out);

for(int i = 0; i < 5 ; i++) {
    byte[] documentBytes =  TSService.generateDocument(dealKey, i);
    ZipEntry zip = new ZipEntry(***your pdf name***);
    zout.putNextEntry(zip);
    zout.write(documentBytes);
    zout.closeEntry();
}

zout.close();