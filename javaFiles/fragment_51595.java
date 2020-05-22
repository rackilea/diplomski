public class RemoveHtmlElements {

    public static void main(String[] args) {

        String html = "<!DOCTYPE html><html><body><h1>My First Heading</h1>"
                + "<p>My first paragraph.</p></body></html>";

        boolean elementsExist = true;
        while(elementsExist) {
            if(html.contains("<")) {
                int open = html.indexOf("<");
                int closed = html.indexOf(">", open);
                html = html.substring(0, open) + " " + html.substring(closed + 1);
            } else {
                elementsExist = false;
            }
        }

        System.out.println(html);

    }

}