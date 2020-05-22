// Indent level = 0 and no ~, so no INDENT here
[IF] [CONOP] [ID b] [CONCL] [THEN]
// Indent level = 0, one ~, so one INDENT
[INDENT]
    // Indent level = 1
    [ID a] [OP =] [CONST 2] [SEMICOLON]
    // Indent level = 1, one ~, so no INDENT here
    [IF] [CONOP] [ID b] [OP &&] [ID c] [CONCL] [THEN]
    // Indent level = 1, two ~, so one INDENT
    [INDENT]
        // Indent level = 2
        [ID a] [ASSIGN] [CONST 3] [SEMICOLON]
        // Indent level = 2, lines starts with no ~, two OUTDENTs
    [OUTDENT]
    // Indent level = 1
[OUTDENT]
//Indent level = 0
[ELSE] // No ~ at start of this line, so no INDENT
// Indent level = 0; one ~, so one INDENT
[INDENT] 
    // Indent level = 1
    [ID a] [ASSIGN] [CONST 4] [SEMICOLON]
// End-of-input.  Indent level = 1, so 1 OUTDENT
[OUTDENT]
// Done; indent level = 0;