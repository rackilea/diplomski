static int heightInInches( int f,int i){
            int in=f*12;
            int inches=i+in;
            return inches;
        }
        static int weightInPounds(int stone, int p){
            int po=stone*14;
            int pounds=p+po;
            return pounds;
        }
        static int calculateBMI(int height,int weight ){
            int w=weight*703;
            int h=height*height;
            int bmi = w/h;
            return bmi;
        }
        public static void main(String[] args){
            Scanner input=new Scanner(System.in);
            System.out.print("Enter height in feet (2-7): ");
            int feet=input.nextInt();
            while( !(feet>= 2 && feet<=7))
            {
                System.out.println("Retry between 2 and 7 :");
                feet=input.nextInt();
            }
            System.out.print("Enter height in inch(0-11): ");
            int inch=input.nextInt();
            while( !(inch>= 0 && inch<=11))
            {
                System.out.println("Retry between 0 and 11 :");
                inch=input.nextInt();
            }
            System.out.print("Enter weight in stone: ");
            int stone=input.nextInt();
            System.out.print("Enter weight in pound: ");
            int pound=input.nextInt();
            int height=heightInInches(feet,inch);
            int weight=weightInPounds(stone,pound);
            int bmi=calculateBMI(height,weight);
            System.out.println("BMI is: "+bmi);
        }