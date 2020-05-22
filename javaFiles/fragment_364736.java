for( AnswerCell cell: answerCells) {
    cell.unhighlight();
}

for( AnswerCell cell: answerCells) {
    if( cell.matches(number)) {
        cell.highlight();
    } 
}