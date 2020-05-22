if (cmd.length > 3 && cmd[0].equals("add")) {
            add(cmd[1], cmd[2], cmd[3]);
        }else{
            System.out.println("Rewrite CMD Please!");
        }
        if (cmd.length > 1 && cmd[0].equals("list")) {
            list(cmd);
        }