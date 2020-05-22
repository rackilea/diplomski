while ((strLine = br.readLine()) != null)
    {
        sb.append(strLine);
        sb.append(System.lineSeparator());
        list.add(strLine);
    }