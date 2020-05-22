public static boolean pieceInWay(final GamePiece[][] board, final Move move) {
        final int changerx = (int) Math.signum(move.getdx());
        final int changery = (int) Math.signum(move.getdy());
        switch (Direction.getFromDelta(changerx, changery)) {
        case DOWN:
            for (int y = move.start.y + 1; y < move.end.y; y++) {
                if (board[y][move.start.x] != null) {
                    return true;
                }
            }
            break;
        case DOWN_LEFT:
            for (int y = move.start.y + 1, x = move.start.x - 1; y < move.end.y; y++, x--) {
                if (board[y][x] != null) {
                    return true;
                }
            }
            break;
        case DOWN_RIGHT:
            for (int y = move.start.y + 1, x = move.start.x + 1; y < move.end.y; y++, x++) {
                if (board[y][x] != null) {
                    return true;
                }
            }
            break;
        case LEFT:
            for (int x = move.start.x - 1; x > move.end.x; x--) {
                if (board[move.start.y][x] != null) {
                    return true;
                }
            }
            break;
        case RIGHT:
            for (int x = move.start.x + 1; x < move.end.x; x++) {
                if (board[move.start.y][x] != null) {
                    return true;
                }
            }
            break;
        case UP:
            for (int y = move.start.y - 1; y > move.end.y; y--) {
                if (board[y][move.start.x] != null) {
                    return true;
                }
            }
            break;
        case UP_LEFT:
            for (int y = move.start.y - 1, x = move.start.x - 1; y > move.end.y; y--, x--) {
                if (board[y][x] != null) {
                    return true;
                }
            }
            break;
        case UP_RIGHT:
            for (int y = move.start.y - 1, x = move.start.x + 1; y > move.end.y; y--, x++) {
                if (board[y][x] != null) {
                    return true;
                }
            }
            break;
        }
        return false;
    }

    @FunctionalInterface
    public static interface IsLegalMove {
        public boolean call(GamePiece piece, GamePiece pieceOnEndTile, GamePiece[][] board, Move move);
    }

    private static enum Direction {
        UP(0, -1),
        UP_RIGHT(1, -1),
        RIGHT(1, 0),
        DOWN_RIGHT(1, 1),
        DOWN(0, 1),
        DOWN_LEFT(-1, 1),
        LEFT(-1, 0),
        UP_LEFT(-1, -1);

        public final int dx;
        public final int dy;

        private Direction(final int dx, final int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public static Direction getFromDelta(final int dx, final int dy) {
            for (final Direction d : values()) {
                if (d.dx == dx && d.dy == dy) {
                    return d;
                }
            }
            return null;
        }
    }