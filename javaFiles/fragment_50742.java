BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
        String s;
        while ((s=br.readLine())!=null) {
            if (s.equals("quit")) {
                break;
            }
            else if (s.matches("\\d{2}")) {
                // parse it (exactly 2 digits)
                System.out.print("parse:"+s);
            }
            else {
                System.out.println("You can only enter 2dig integers or 'quit'.");
            }
        }