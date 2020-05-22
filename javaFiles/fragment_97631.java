class Inp {
    public void scan() {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        while (true) {
            String sr = sc.nextLine();
            String[] tk = sr.split(" ");
            Integer key = 0, value = 0;
            try {
                key = Integer.parseInt(tk[0]);
                value = Integer.parseInt(tk[1]);
            }
            catch (NumberFormatException e) {
                break;
            }
            map.put(key,value);
        }

    }

    public static void main(String[] args) {
       Inp inp = new Inp();
       inp.scan();

    }
}