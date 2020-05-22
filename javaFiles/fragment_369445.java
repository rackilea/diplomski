if(player == max && best_move!=null && aplha_beta <= best_move.getRating()) {

           return(best_move);
 }

 if(player == min && best_move!=null && alpha_beta >= best_move.getRating()) {

        return(best_move);
 }

 Field best_deep_move = findBestMove(temp_board,depth+1,!player,best_move.getRating());