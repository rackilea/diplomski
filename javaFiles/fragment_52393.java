DoStatement:
    do Statement while ( Expression ) ;

Statement:
    WhileStatement

WhileStatement:
    while ( Expression ) Statement

Statement:
    Block

Block:
    { BlockStatements_opt }