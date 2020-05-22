out = new BufferedWriter(
                  new OutputStreamWriter(connection.getOutputStream())
                  );
          out.write(getOutput(hm));

          out.close();