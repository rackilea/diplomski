int score =0;
        int i =1;
        while(i<=key.length-1)
          {
            if(key[i].equalsIgnoreCase(student[i+2]))
            {
              score++;
              i++;
            }
            else
              i++;

          tscore += score;
          scount++;
          }
        if(scount == 0)
            System.out.println ("Empty class data");

        System.out.println(scount);
        System.out.println ("Results for quiz " + key[0] + ":" +'\n');    
        System.out.println (id + " " +fname+ " "+lname+" "+score);
        System.out.println(key[1] +":"+student[3]);
        input = br.readLine ();
      }