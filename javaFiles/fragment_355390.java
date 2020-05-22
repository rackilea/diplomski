String stringSplit = null;
           Scanner s = new Scanner(Node);
           while (s.hasNext()) {

            if (s.next().contains("window.maybeRedirectForGBV")){
                stringSplit = s.next();
                break;
            }
           }