public static void main(String[] args) {
        String s = "hello/bye"; 
        //if(s.contains("/")){ No need to check this
            System.out.println(s.replaceAll("(.*?)/(.*)", "$2/$1")); // () is a capturing group. it captures everything inside the braces. $1 and $2 are the captured values. You capture values and then swap them. :P
        //}

    }