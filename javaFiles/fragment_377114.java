while ((line = br.readLine()) != null)
        {
            String[] numbers = line.split("\\W+");
            for ( int i = 0 ; i < 25 ; i++){ 
                 matrix[lineCount][i] = Double.parseDouble(numbers[i].trim());
                 System.out.println(matrix[lineCount][i] + " " + i + " " +lineCount);
            }//Note 1
            lineCount++;

        }