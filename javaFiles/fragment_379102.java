public static void main(String[] args) {

        int n, x, flag = 0, i = 0;
        Scanner s = new Scanner(System.in);
        int a[] = new int[10];
        System.out.println("Enter all the values:");
        for(i = 0; i < 10; i++)
        {
            System.out.print("Value "+(i+1)+": ");
            a[i] = s.nextInt();

        }

        System.out.print("Enter the value you want to find: ");
        x = s.nextInt();

        i = find(a, 10, x);
        if(i != -1)
        {
            System.out.println("The value "+x+" is found at index "+(i+1));
        }

        else
        {
            System.out.println("The value "+x+" is found at index "+(-1));
        }
    }

    private static int find(int a[],int n, int x) {
            int i, flag = 0;
        for(i = 0; i < n; i++)
        {
            if(a[i] == x)
            {
                flag = 1;
                break;
            }

            else
            {
                flag = 0;
            }

        }
        if(flag == 1) {
            return i;
        } else {
            return -1;
        }
    }