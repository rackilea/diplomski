while (true) {
            String telnetCommand = dataIn.readLine();

            System.out.println(telnetCommand);

            String dataInArray[] = telnetCommand.split(" ");

            if (dataInArray.length == 2) {
                user.isValid(dataInArray[0], dataInArray[1]);
            }

            if (dataInArray.length < 2) {
                if (telnetCommand.equals("CONTINUE")) {
                    continueThisSession();
                    System.out.println("Running method continueThisSession");
                }

                if (telnetCommand.equals("SKIP_N")) {
                    skipEveryNthData();
                    System.out.println("Running method skipEveryNthData");
                }

                if (telnetCommand.equals("BATCH_N")) {
                    batchEveryNthData();
                    System.out.println("Running method batchEveryNthData");
                }

                if (telnetCommand.equals("logout")  || telnetCommand.equals("exit")) {
                    break;
                }
            }
        }