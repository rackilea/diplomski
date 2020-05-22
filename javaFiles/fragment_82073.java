@Converter(autoApply=true)
public class ListIntegerStringConverter implements AttributeConverter<List<Integer>, String>
{
    public String convertToDatabaseColumn(List<Integer> attribute)
    {
        if (attribute == null)
        {
            return null;
        }
        StringBuilder str = new StringBuilder();
        for (Integer val : attribute)
        {
            if (str.length() > 0)
            {
                str.append(",");
            }
            str.append(val);
        }
        return str.toString();
    }

    public List<Integer> convertToEntityAttribute(String dbData)
    {
        if (dbData == null)
        {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        StringTokenizer tokeniser = new StringTokenizer(dbData, ",");
        while (tokeniser.hasMoreTokens())
        {
            list.add(Integer.valueOf(tokeniser.nextToken()));
        }

        return list;
    }
}