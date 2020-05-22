@RequestMapping(method=RequestMethod.GET,value="/specquestions/{subject}/{topic}")
    public ResponseEntity<List<QuestionBank>> getSpecificQuestions(@PathVariable String subject,@PathVariable String topic) {

        return ResponseEntity.ok( questionBankService.getSpecificquestions(subject,topic));

    }