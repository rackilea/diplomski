/* array references look like functions to Groovy so trap them */
    BinsicInterpreter.metaClass."$varName" = {Object[] arg ->
        def answer = "package binsic; $varName"
        arg.each { 
            answer = answer + "[$it]"
        }
        def something = shell.evaluate(answer)
        return something
    }