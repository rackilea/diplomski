excep = jenv->NewObject(eclass, jid,
            jmp,
            e.getApiErrNum(),
            message,
            file,
            e.getLineNum());