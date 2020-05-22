public class Response {
    int a, b, c, d;
    char operator = '?';

    public Response(Equation equ) {
        Random r = new Random();
        switch (r.nextInt(4)) {

            case 0:
                a = r.nextInt(2 * equ.z);
                break;

            case 1:
                b = r.nextInt(2 * equ.z);
                break;

            case 2:
                c = r.nextInt(2 * equ.z);
                break;
            case 3:
                d = equ.z;
                break;
            default:
                operator = '?';
        }
    }
}