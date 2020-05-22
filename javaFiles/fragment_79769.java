//jquerypart 
formData.append("vo",{pName:pName,pPrice:pPrice});

 //java part

 @RequestMapping(value = "/pupload", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
 public ResponseEntity<String> pUpload2(@RequestParam String vo,@RequestParam(required = false) MultipartFile file, Model model) throws Exception { 

       String fileName = file.getName();
       model.addAttribute("fileName", fileName);
       ObjectMapper objectMapper=new ObjectMapper();
       ProductVo voc = objectMapper.readValue(vo, ProductVO.class); 
       pservice.regist(voc);
       return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath,file.getOriginalFilename(), file.getBytes()),HttpStatus.CREATED);
}