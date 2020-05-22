try (FileWriter fw = new FileWriter("c:/temp/tt.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
        writeToFile(mystring, out);
        out.close();
    } catch (IOException e) {
        e.printStackTrace();
    }