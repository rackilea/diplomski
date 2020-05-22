dis = new DataInputStream(is);
 while(dis.available()>0) {

            // read four bytes from data input, return int
            int k = dis.readInt();

            // print int
            System.out.print(k+" ");
         }