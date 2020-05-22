StringBuilder sb = new StringBuilder();
    String outputContent;
    while ((outputContent = br.readLine()) != null) {
        sb.append(outputContent).append('\n');
    }

    br.close();

    return= sb.toString(); // Final result, no more