try {

            RandomAccessFile raf = new RandomAccessFile(new File(
                    "C://users//XX//desktop//names.txt"),
                    "rw");

            for (int j = 0; j < args.length; j++) {
                output.append(args[j] + ":");
                while ((nameFile = raf.readLine()) != null) {

                    if (args[j].equalsIgnoreCase(nameFile)) {
                        output.append(" " + nameFile + ", ");

                    }

                }
                raf.seek(0);
            }
            System.out.println(output + "\r\n");

        } catch (IOException e) {
            e.printStackTrace();
        }