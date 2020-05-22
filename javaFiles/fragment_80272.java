@RequestMapping(value="/questionType/MCQ.do",method = RequestMethod.POST)
 public ModelAndView saveMCQuestion(@RequestParam("option1") String option1,@RequestParam("option2") String option2 ,@RequestParam("img1") MultipartFile img1,@RequestParam("img2") MultipartFile img2,@ModelAttribute McqItem mcqItem, HttpServletRequest request)throws IOException{
  ModelAndView modelAndView = new ModelAndView();
  QuizItem quizitem=(QuizItem)request.getSession().getAttribute("quizItem");
  mcqItem.setQuiz_id(String.valueOf(quizitem.getId()));
  QuizItem qType=(QuizItem)request.getSession().getAttribute("qTypeItem");
  mcqItem.setQType(qType.getItemType());
  
//begin the uploading section

  byte[] img1File=null;
  byte[] img2File=null;
  if(!img1.isEmpty() && !img2.isEmpty()){
  try{
   img1File= img1.getBytes();
   img2File=img2.getBytes();
   
   BufferedOutputStream stream= 
     new BufferedOutputStream(new FileOutputStream(new File(option1)));
   stream.write(img1File);
   stream.write(img2File);
   stream.close();
   System.out.println("Successful Upload");
  }catch(Exception e){
   return null;
  } }
  
  
//end Uploading section
 
  projectDAO.saveQuestion(mcqItem);
  modelAndView.addObject("qtypeitem", new QuizItem());
  modelAndView.setViewName("project/qType");
  
  return modelAndView;
  
 }