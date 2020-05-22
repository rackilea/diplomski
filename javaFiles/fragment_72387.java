for (int i = 0; i < 2; i++) {

     int val = minimax(depth + 1, nodeIndex.getLeft(), false, alpha, beta);
                best = Math.max(best, val);
                alpha = Math.max(alpha, best);

                //Alpha Beta Pruning
                if (beta <= alpha) {
                    break;
                }