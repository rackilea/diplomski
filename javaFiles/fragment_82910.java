preprocessorDeclaration
@after {System.out.println("Preprocessor found : " + $text);}
    :   PreprocessorBlock
    ;

PreprocessorBlock
    :   '#' ~[\r\n]*
//        -> channel(HIDDEN)
    ;