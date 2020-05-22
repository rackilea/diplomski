public static void main(String[] args)
{
    short flag = 0x0080;

    int foo1 = 128; // 0x00000080

    if ((foo1 & flag) == 0)
        System.out.println("Hit 1!");

    int foo2 = 0; // 0x00000000

    if ((foo2 & flag) == 0)
        System.out.println("Hit 2!");

    int foo3 = 27698; // 0x00006C32

    if ((foo3 & flag) == 0)
        System.out.println("Hit 3!");
}

// Output: Hit 2! Hit 3!