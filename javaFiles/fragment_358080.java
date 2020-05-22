public class Main {
    public static void main(String[] args){
        String str="Schooled";
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<str.length();i++)
            if(i%2==0)
                sb.append(str.charAt(i));
        System.out.println(sb);
    }
}