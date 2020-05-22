public board recursiveSolve(Board board, Piece[] pieces, int position,int start){
if(position  == board.getLength())
    return board;
else { 
    //starting from start instead from 0
    for(int i = start; i < pieces.length; i++){
        if(board.isValid(piece[i], position)){
            board.putPiece(pieces[i], position);
            swap(pieces,start,i); //the swap() method I mentioned above        
            //sending start+1:
            if(recursiveSolve(board, subPieces, position + 1,start+1) != null) 
                 return board;
            else
                 board.removePiece(position);
        }
    }
    return null;
}