try{

        if ((new File("c:\\your_file.pdf")).exists()) {

            Process p = Runtime
               .getRuntime()
               .exec("rundll32 url.dll,FileProtocolHandler c:\\your_file.pdf");
            p.waitFor();

        } else {

            System.out.println("File does not exist");

        }

      } catch (Exception ex) {
        ex.printStackTrace();
      }