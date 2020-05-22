ClassBody: 
    { { ClassBodyDeclaration } }

ClassBodyDeclaration:
    ; 
    {Modifier} MemberDecl
    [static] Block

MemberDecl:
    ...
    InterfaceDeclaration