@Action(value = "download", 
    results = {
        @Result(name = "success", type = "stream", params = {
                "contentType"        , "text/xml",
                "inputName"          , "fileInputStream",
                "contentDisposition" , "attachment;filename=\"foobar.xml\""
        }),
        @Result(name = "input", location = "testMM.jsp") 
    }
)