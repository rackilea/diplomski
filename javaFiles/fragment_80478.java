Elements addresses = doc.select("address > :not(div[class=phone])");
    for (Element address : addresses) {
        for (Node node : address.childNodes()) {
            if (node.nodeName().equals("br")) {
                continue;
            }
            String text = node.toString().trim();
            System.out.println(text);
        }
    }