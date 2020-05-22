<cfscript>
    helloWorld = "Hello, World!";
    utf8HashCF = lcase(hash(helloWorld, 'MD5', 'UTF-16LE'));
</cfscript>
<cfoutput>
    #utf8HashCF# <br />
</cfoutput>