response.setContentType("application/x-download");
response.setHeader("Content-disposition", "attachment; filename=" + fileName);
response.flushBuffer();

function download(fileName) {
    window.location.href = "/download?description=test&logId=123";
}