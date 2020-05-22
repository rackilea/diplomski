grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.xbase.Xbase

generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"

import "http://www.eclipse.org/xtext/common/JavaVMTypes" as types

Model:
    imports=XImportSection?
    elements+=Element*
    ;

Element:
    "element" "{"
        "modelname" "=" type=JvmTypeReference
        "variable" "names" "=" memberReferences+=MemberReference ("," memberReferences+=MemberReference)*
    "}"
;

MemberReference:
    member=[types::JvmField|ID]
;