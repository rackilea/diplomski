while (true) { // but you must specify some condition to stop the while
            FromServer = inFromServer.readLine();
            System.out.println(FromServer);

            PrintWriter outToServer = new PrintWriter(client.getOutputStream(), true);
            ToServer = inFromUser.readLine();

            outToServer.println(ToServer);
            outToServer.flush();
        }