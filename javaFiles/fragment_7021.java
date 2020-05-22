for (String s : returns) {
     String[] s2=s.split("-");
     out.append("<DIV>");
     for(String results : s2){
        out.append(results);
        out.append("&nbsp;");
     } 
     out.append("</DIV>");
}