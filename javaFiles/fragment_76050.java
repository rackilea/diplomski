Pattern patternObject = Pattern.compile("<a class=\"cit-dark-link(.*?)cites=(\\d)+\">(.*?)</a>");
            Matcher matcherObject = patternObject.matcher(HTML);

            while (matcherObject.find()) {
                    System.out.println("DEBUG: Cite is " + matcherObject.group(3));
              }