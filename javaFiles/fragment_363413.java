<xjavac srcdir="${build.src}"
       destdir="${build.dest}"
       source="${javac.source}"
       target="${javac.target}"
       classpath="${build.dir}/classes:${tools.dir}/${jar.apis}:${tools.dir}/${jar.resolver}:${tools.dir}/${jar.serializer}"
       debug="${debug}"
       debuglevel="${debuglevel}"
       deprecation="${deprecation}"
       optimize="${optimize}"
       includeAntRuntime="false"
       includeJavaRuntime="false"
       excludes="org/xml/sax/** 
            javax/xml/**
            org/w3c/dom/*
            org/w3c/dom/bootstrap/**
            org/w3c/dom/events/**
            org/w3c/dom/ls/**
            org/w3c/dom/html/**
            org/w3c/dom/ranges/**
            org/w3c/dom/traversal/**
            org/w3c/dom/views/**
            org/w3c/dom/xpath/**"
       >
       <compilerarg line="-Xbootclasspath/p:${tools.dir}/${jar.apis}"/>
</xjavac>