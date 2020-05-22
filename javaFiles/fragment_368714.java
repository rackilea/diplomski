public static String MaptoXML(Map<String,Object> params, String root)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(root);
        sb.append(">");

        Iterator<String> it = params.keySet().iterator();
        while(it.hasNext())
        {
            String key = it.next();
            Object obj = params.get(key);

            if(obj instanceof Map)
            {
                Map<String, Object> rec = (Map)obj;
                String s ;
                s = MaptoXML(rec,key);
                sb.append(s);
            }
            else
            {
                sb.append("<");
                sb.append(key);
                sb.append(">");

                sb.append(params.get(key));

                sb.append("</");
                sb.append(key);
                sb.append(">"); 
            }
        }
        sb.append("</");
        sb.append(root);
        sb.append(">");

        return sb.toString();   
    }