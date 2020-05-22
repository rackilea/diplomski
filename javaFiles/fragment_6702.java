public class d {
    public static boolean isHTMLMatched(String html) {
        Stack<String> buffer = new Stack<>();
        String st="";//ADDED BY ME
        String s="";//ADDED BY ME
        int j = html.indexOf('<');
        while(j != -1) {
            int k = html.indexOf('>', j+1);
            if(k == -1) {
                return false;
            }
            String tag = html.substring(j+1, k);
            if(!tag.startsWith("/")) {
                buffer.push(tag);
            }
            else {
                if(buffer.isEmpty()) {
                    return false;
                }         
                s=buffer.pop();//ADDED BY ME
                if(s.indexOf(" ")!=-1)//ADDED BY ME
                    st=s.substring(0, s.indexOf(" "));//ADDED BY ME
                else st=s;//ADDED BY ME
                if(!tag.substring(1).equals(st)) {//<----------------PROBLEM WAS HERE
                    return false;
                }
            }
            j = html.indexOf('<', k+1);
        }
        return buffer.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isHTMLMatched("<table border = \"3\"> </table>"));
    }
}