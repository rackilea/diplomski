/**
 * Let's assume the result is not obvious here regardless it's a nth triangular number.
 * Added there a System.out though.
 */
public void calc(int i) {
    System.out.println(i);

    if (i == 0)
        return 0;
    return i + calc(i - 1);
}