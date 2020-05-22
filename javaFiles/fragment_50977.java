while ((line = fp.readLine()) != null) {
    StringTokenizer st = new StringTokenizer(line, " \t\n\r\f:");
        if (st.countTokens() == 5) {
            byte value = (byte) atoi(st.nextToken());
            st.nextToken();
            double x = atof(st.nextToken());
            st.nextToken();
            double y = atof(st.nextToken());
            point_list.addElement(new point(x, y, value));
        } else if (st.countTokens() == 3) {
            double y = atof(st.nextToken());
            st.nextToken();
            double x = atof(st.nextToken());
            point_list.addElement(new point(x, y, current_value));
        } else {
            break;
        }
    }