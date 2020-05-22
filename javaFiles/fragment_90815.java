while (values.hasNext()){

        IntWritable filename = values.next();
        System.out.println("value.next" + filename );
        if( !(files.contains(filename))){  
            files.add(filename);

            if (count!=0)
                toReturn.append("-> ");

            count++;
            toReturn.append(filename);
        }
    }