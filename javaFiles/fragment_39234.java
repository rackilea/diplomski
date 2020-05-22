while (true) { // but you must specify some condition to stop the while
                outToClient.println("Turning on light " + n);
                outToClient.flush();
                fromclient = inFromClient.readLine();
                System.out.println("User pressed light " + fromclient);

                score = scoreCheck(check, fromclient);
                System.out.println("Score = " + score);
            }