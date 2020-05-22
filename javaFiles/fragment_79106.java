while (null != (temp = reader.readLine())) {
            bools[i] = Boolean.parseBoolean(temp);

            // output what you read
            System.out.println(bools[i]);
            i++;
        }