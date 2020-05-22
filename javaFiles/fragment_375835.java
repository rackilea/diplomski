public class Source {
public static void main(String[] args) {
    int current_square_num = 4;
    int row_num = 2;
    int col_num = 2;
    int arg_num = 2;
    char[][][][] hilbert_map = new char[current_square_num][row_num][col_num][arg_num];

    // >>> 'a': {(0, 0): (0, 'd'), (0, 1): (1, 'a'), (1, 0): (3, 'b'), (1, 1): (2, 'a')}
    hilbert_map[0][0][0][0] = '0';
    hilbert_map[0][0][0][1] = 'd';

    hilbert_map[0][0][1][0] = '1';
    hilbert_map[0][0][1][1] = 'a';

    hilbert_map[0][1][0][0] = '3';
    hilbert_map[0][1][0][1] = 'b';

    hilbert_map[0][1][1][0] = '2';
    hilbert_map[0][1][1][1] = 'a';

    // >>> 'b': {(0, 0): (2, 'b'), (0, 1): (1, 'b'), (1, 0): (3, 'a'), (1, 1): (0, 'c')}
    hilbert_map[1][0][0][0] = '2';
    hilbert_map[1][0][0][1] = 'b';

    hilbert_map[1][0][1][0] = '1';
    hilbert_map[1][0][1][1] = 'b';

    hilbert_map[1][1][0][0] = '3';
    hilbert_map[1][1][0][1] = 'a';

    hilbert_map[1][1][1][0] = '0';
    hilbert_map[1][1][1][1] = 'c';

    // >>> 'c': {(0, 0): (2, 'c'), (0, 1): (3, 'd'), (1, 0): (1, 'c'), (1, 1): (0, 'b')}
    hilbert_map[2][0][0][0] = '2';
    hilbert_map[2][0][0][1] = 'c';

    hilbert_map[2][0][1][0] = '3';
    hilbert_map[2][0][1][1] = 'd';

    hilbert_map[2][1][0][0] = '1';
    hilbert_map[2][1][0][1] = 'c';

    hilbert_map[2][1][1][0] = '0';
    hilbert_map[2][1][1][1] = 'b';

    // >>> 'd': {(0, 0): (0, 'a'), (0, 1): (3, 'c'), (1, 0): (1, 'd'), (1, 1): (2, 'd')}
    hilbert_map[3][0][0][0] = '0';
    hilbert_map[3][0][0][1] = 'a';

    hilbert_map[3][0][1][0] = '3';
    hilbert_map[3][0][1][1] = 'c';

    hilbert_map[3][0][1][0] = '1';
    hilbert_map[3][0][1][1] = 'd';

    hilbert_map[3][1][1][0] = '2';
    hilbert_map[3][1][1][1] = 'd';

    double order = 3;

    for (int col = 0; col < Math.pow(2, order); col++) {
        for (int row = 0; row < Math.pow(2, order); row++) {
            System.out.println("(" + row + ", " + col + "): " + point_to_hilbert(row, col, (int) order, hilbert_map));
        }
    }

}

public static int point_to_hilbert(int x, int y, int order, char[][][][] hilbert_map) {
    int position = 0;
    int current_square = 0 /* 'a' */;

    for (int i = 0; i < order; i++) {
        position = position << 2; // >>> position <<= 2

        int quad_x;
        int quad_y;

        if ((x & (1 << i)) != 0) { // >>> quad_x = 1 if x & (1 << i) else 0
            quad_x = 1;
        } else {
            quad_x = 0;
        }

        if ((y & (1 << i)) != 0) { // >>> quad_y = 1 if y & (1 << i) else 0
            quad_y = 1;
        } else {
            quad_y = 0;
        }

        current_square = 0;
        // >>> quad_position, current_square = hilbert_map[current_square][(quad_x, quad_y)]
        char quad_position = hilbert_map[current_square][quad_x][quad_y][0];
        current_square = Character.getNumericValue(hilbert_map[current_square][quad_x][quad_y][1]);
        // >>> position |= quad_position
        position = position | Character.getNumericValue(quad_position);
    }

    return position;
}

}