formData.append("pName",pName);
  formData.append("pPrice",pPrice);


 @RequestMapping(value = "/pupload", method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
 public ResponseEntity<String> pUpload2(@RequestParam String pName,@RequestParam String pPrice,@RequestParam(required = false) MultipartFile file, Model model) throws Exception { 
     ProductVO vo=new ProductVo();
      vo.setPName(pName);
      vo.setpPrice(pPrice);
       ......

  }