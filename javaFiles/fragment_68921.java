public class Main {

    public static void main(String[] args) {
    // write your code here
        Node exampleNode = new Node();
        exampleNode.mySentence="academy concern manager".toLowerCase();
        exampleNode.chars="ACM".toLowerCase().toCharArray();
        exampleNode.nextNode();
        System.out.println(getOutput(exampleNode));

        exampleNode = new Node();
        exampleNode.mySentence="Radio addition ranger".toLowerCase();
        exampleNode.chars="RADAR".toLowerCase().toCharArray();
        exampleNode.nextNode();
        System.out.println(getOutput(exampleNode));
    }
    public static int getOutput(Node node){
        int output=0;

        if(node.chars.length==0&& node.mySentence.indexOf(" ")==-1){
            Node nextNode=node;
            String s="";
            while (nextNode!=null){
                 String sub =nextNode.myChar+nextNode.mySentence;
                 s=replaceLast(s.toLowerCase(),"",sub)+s;
                 nextNode = nextNode.father;
            }

            boolean wordWithoutChar = false;
            for (String word:s.split(" ")) {
                boolean noCharInThisWord=true;
                for (char c:word.toCharArray()) {
                    if(c<='Z'&&c>='A'){
                        noCharInThisWord = false;
                    }
                }
                if(noCharInThisWord){
                    wordWithoutChar=noCharInThisWord;
                }
            }
            if(!wordWithoutChar){
                System.out.println(s);
                output++;
            }
        }
        for (Node n:node.nodes) {
            output +=getOutput(n);
        }
        return output;
    }
    public static String replaceLast(String find, String replace, String string) {
        int lastIndex = string.lastIndexOf(find);

        if (lastIndex == -1) {
            return string;
        }

        String beginString = string.substring(0, lastIndex);
        String endString = string.substring(lastIndex + find.length());

        return beginString + replace + endString;
    }

    public static class Node{
        List<Node> nodes = new ArrayList<>();
        Node father =null;
        char myChar=0;
        char[] chars=null;
        String mySentence="";
        public void nextNode() {
            int index=0;
            if(chars.length>0){
                while (index<mySentence.length()){
                    if(mySentence.toCharArray()[index]==chars[0]){
                        Node son = new Node();
                        son.chars = Arrays.copyOfRange(chars, 1, chars.length);
                        son.mySentence=mySentence.substring(index+1);
                        son.father=this;
                        son.myChar= (char) (chars[0]-32);
                        son.nextNode();
                        nodes.add(son);
                    }
                    index++;
                }
            }
            return;

        }
    }

}