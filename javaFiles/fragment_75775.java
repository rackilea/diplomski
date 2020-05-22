<javac srcdir="${src}" destdir="${classes}" ... > 
     ....
     <compilerarg line="-processorpath ${processorpath}"/>
     <compilerarg line="-processor ${processor}"/>
     <compilerarg line="-s ${whereToPutGeneratedClassFiles}"/>
</javac>