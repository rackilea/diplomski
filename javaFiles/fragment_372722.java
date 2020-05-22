String input = "−+-~*/@$^#¨%={}[häagen-dazs;:] a (le & co') jsou výborné <značky>?!";
    StringBuffer sb =  new StringBuffer();
    for(char c : input.toCharArray()){
       if((Character.toString(c).toLowerCase()).matches("[a-zA-Z& \\-_\\.ýčéèêàâùû]")){
           sb.append(c);
       }
    }
    System.out.println(sb.toString());