for (String[] output : allRows) {
        // get current row
        for (int i = 0; i < output.length; i++) {
            String[] tokens = tokenizer.tokenize(output[i]);
            System.out.println(tokens);

            // write line
            writer.writeNext(tokens);
        }
    }
    writer.close();