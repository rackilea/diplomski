try {
            File[] uiDiffDir = getFiles();

            for (File file : uiDiffDir) {

                String[] cmd = {"sh", shellScriptPath, file1, file2,
                        outputfile};
                Process p = Runtime.getRuntime().exec(cmd);
                p.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        p.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }