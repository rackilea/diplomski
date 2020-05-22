@RequestMapping(value = "/getFileById/{id}", method = RequestMethod.GET)
public @ResponseBody
void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
    organizationFileAttachmentService.setUser(getUser());
    GridFSDBFile file = organizationFileAttachmentService.getGridFSDBFileById(new ObjectId(id), "File");
    if (file != null) {
        try {
            response.setContentType(file.getContentType());
            response.setContentLength((new Long(file.getLength()).intValue()));
            response.setHeader("content-Disposition", "attachment; filename=" + file.getFilename());// "attachment;filename=test.xls"
            // copy it to response's OutputStream
            IOUtils.copyLarge(file.getInputStream(), response.getOutputStream());
        } catch (IOException ex) {
            _logger.info("Error writing file to output stream. Filename was '" + id + "'");
            throw new RuntimeException("IOError writing file to output stream");
        }
    }
}