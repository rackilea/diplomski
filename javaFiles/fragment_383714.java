if (currentItem != null) {
        //temp.append(ch, start, length);
        String tmpLink = currentElement.getLink();
        tmpLink += new String(ch, start, length);
        currentElement.setLink(tmpLink);

   }