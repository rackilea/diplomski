while((count =IS.read(fileByte))>0 ){
            fos.write(fileByte);
            fos.flush();
          }
          fos.flush();
          fos.close();