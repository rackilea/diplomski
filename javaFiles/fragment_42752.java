FileWriter writer = null;

    try {       
        writer = new FileWriter("MBM_Log_"+date()+".txt" , true);
        PrintWriter out = new PrintWriter(writer);
        out.printf("%s"+"%n", texLine);
                    out.close();
        } catch (IOException exception) {
        System.err.println("log error");
        exception.printStackTrace();
        }

    finally {
        if (writer != null) {
            try {
                writer.close();
                } catch (IOException exception) {
                System.err.println("Error closing writer");
                exception.printStackTrace();
            }
        }
    }

    }