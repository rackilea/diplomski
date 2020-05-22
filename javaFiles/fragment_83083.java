$(document).on("click","#downlodMarksSheet",function(event){
            var examCatId=$("#meExamMainEV").val();     
            var classId=$(".mainContainer #meClass").val();  
            var secId=$(".mainContainer #sectionId").val() ;
            var stringFromDate=$(".mainContainer #FromDate").val();
            var stringToDate=$(".mainContainer #ToDate").val();
            var url = contextPath+"/excel/exportExcel/"+classId+"/"+secId+"/"+examCatId+"/"+stringFromDate.replace(/\//g, "-")+"/"+stringToDate.replace(/\//g, "-");
            window.location.href=url;
        });

**java code :**

@GetMapping(value = "/exportExcel/{classId}/{secId}/{examCatId}/{stringFromDate}/{stringToDate}")
    public HttpServletResponse updateStudentGeneralDetailss(@PathVariable("classId") int classId,
            @PathVariable("secId") int secId,@PathVariable("examCatId") int examCatId,
            @PathVariable("stringFromDate") String stringFromDate,
            @PathVariable("stringToDate") String stringToDate,HttpServletRequest request,HttpServletResponse response) {

        try { 



            String filename="";
            XSSFWorkbook hwb=new XSSFWorkbook();  
            XSSFSheet sheet =  hwb.createSheet("Exam Marks Entry");  
            XSSFRow subsHead=   sheet.createRow(0);
            subsHead.createCell(1).setCellValue("");
            XSSFRow subSubsIdsHead=   sheet.createRow(1);
            XSSFRow subSubs=   sheet.createRow(2);



            response.setContentType("application/vnd.ms-excel");

            ServletOutputStream outStream = response.getOutputStream();


            XSSFColor myColor = new XSSFColor(Color.YELLOW);

            XSSFCellStyle style = hwb.createCellStyle();  
            style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
            style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
            style.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());

            style.setBorderBottom(CellStyle.BORDER_THIN);
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderLeft(CellStyle.BORDER_THIN);
            style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderRight(CellStyle.BORDER_THIN);
            style.setRightBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderTop(CellStyle.BORDER_THIN);
            style.setTopBorderColor(IndexedColors.BLACK.getIndex());  



                ExmaExportDTO mainDisplayDto  = service.getExamPartten(examCatId, classId, secId,stringFromDate.replaceAll("-", "/"),stringToDate.replaceAll("-", "/"));

            List<ExamStudentMarksDisplaySubjectsDTO> subjects=  mainDisplayDto.getSubjectsList();
            int i=2;
            int formCol=2;
            int subsubCol=2;

            sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
            sheet.addMergedRegion(new CellRangeAddress(1,1,0,1));

            Cell cel=subSubs.createCell(0); 
            cel.setCellStyle(style);  
            cel.setCellValue("Student Ids");

            Cell cel1=subSubs.createCell(1);
            cel1.setCellStyle(style);  
            cel1.setCellValue("Student Name");

            /*iterating subjects*/
            for(ExamStudentMarksDisplaySubjectsDTO subObj : subjects)
            {  
                Cell cell=subsHead.createCell(formCol);
                cell.setCellStyle(style);
                cell.setCellValue(subObj.getSubjectName());;
                List<ExamStudentMarksDisplaySubjectsSubCatDTO> subSubj=subObj.getSubCatMarks();

                int subSubjLen=subSubj.size(); 

                int toCol=formCol+subSubjLen;

                sheet.addMergedRegion(new CellRangeAddress(0,0,formCol,toCol-1));

                for(ExamStudentMarksDisplaySubjectsSubCatDTO subsubObj :subSubj)
                {
                    Cell cell1=subSubsIdsHead.createCell(subsubCol);
                    cell1.setCellStyle(style);
                    cell1.setCellValue(subsubObj.getExmSubjectSubCategory());
                    Cell cell2=subSubs.createCell(subsubCol);
                    cell2.setCellStyle(style);  
                    cell2.setCellValue(subsubObj.getSubCatName()+"("+subsubObj.getSubCatMaxMarks()+")");
                    subsubCol++;
                }

                formCol=subSubjLen+formCol;;  
                i++;        
            }
            Cell cella=subSubs.createCell(subsubCol);
            cella.setCellStyle(style);
            cella.setCellValue("Description");

            Cell cell1a=subSubs.createCell(subsubCol+1);
            cell1a.setCellStyle(style);
            cell1a.setCellValue("No.of Working Days");

            Cell cell2a=subSubs.createCell(subsubCol+2);
            cell2a.setCellStyle(style);
            cell2a.setCellValue("No.of Present Days");


            List<ExamStudentMarksDisplayStudentsDTO> students=mainDisplayDto.getStudentList();
            /*iterating students*/
            int j=3;
            for(ExamStudentMarksDisplayStudentsDTO stu : students)
            {
                XSSFRow rows=   sheet.createRow(j);
                Cell cell3=rows.createCell(0);
                cell3.setCellStyle(style);
                cell3.setCellValue(stu.getStudentId());
                String lastName="";
                if(stu.getLastMame() !=null)
                {
                    lastName=stu.getLastMame();
                }
                Cell cell4=rows.createCell(1);
                cell4.setCellStyle(style); 
                cell4.setCellValue(stu.getFirstName()+" "+lastName);
                j++;
            }  

            response.setHeader("Content-Disposition", "attachment; filename="+mainDisplayDto.getClassName()+""+mainDisplayDto.getExamName()+".xlsx");
            hwb.write(outStream);
            outStream.close();

        }
catch (Exception e) {  
    e.printStackTrace();
}
        return response;
    }