EnumConstants:
    EnumConstant
    EnumConstants , EnumConstant

EnumConstant:
    Annotations_opt Identifier Arguments_opt ClassBody_opt

Arguments:
    ( ArgumentList_opt )

EnumBodyDeclarations:
    ; ClassBodyDeclarations_opt