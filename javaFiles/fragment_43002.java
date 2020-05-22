private String getCsv(Object obj, boolean isHeader) throws IllegalAccessException
    {
        Field[] fields = obj.getClass().getFields();
        StringBuilder sb = new StringBuilder();

        String prefix = "";
        for (Field field : fields)
        {
            if (isHeader)
            {
                sb.append(prefix).append(field.getName());
            }
            else
            {
                sb.append(prefix).append(field.get(obj));
            }
            prefix = ",";
        }
        return sb.toString();
    }