try (Workbook workbook = new XSSFWorkbook()) {
                new XlsExporter().exportXls(workbook, grh);
                SimpleDateFormat sdf = new SimpleDateFormat("_dd_MM_yyyy_HH_mm");
                String name = grh.getReportName() + sdf.format(new Date());
                name = URLEncoder.encode(name,"UTF-8"); 
                response.setContentType(MediaType.APPLICATION_OCTET_STREAM.getType());
                response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + name +  ".xlsx\"");
                workbook.write(response.getOutputStream());
                response.getOutputStream().flush();
            }