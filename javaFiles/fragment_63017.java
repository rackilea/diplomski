class SampleWebscript extends WebscriptBase {

  override def execute(req: WebScriptRequest, response: WebScriptResponse): Unit = {

  try {
    response.setContentType(MIMETYPE_JSON)
    val writer = new PrintWriter (response.getWriter)
    writer.println("{'Hopp':'Topp'}")
  }

 }

 }