while (strLine != null)
    {
        strLine = br.readLine();
        if (strLine==null)
            break;
        sb.append(strLine);
        sb.append(System.lineSeparator());
        list.add(strLine);
    }