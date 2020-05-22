Runtime.getRuntime().exec(
            "C:/masm32/bin/ml.exe "        //directory of assembler
            +"/coff "                      //create COFF header (needed for Win32)
            +"/Bl C:/masm32/bin/link.exe " //directory of linker 
            +"/Fe src/" + fileName + ".exe " //executable file
            +"/Fo src/" + fileName + ".obj " //object file
            + fileName + ".asm");            //assembly file (source)