public class Ticket {

    private static class Field {
        int intValue;
        String stringValue;
        final Class type;

        Field(Class fieldType){
            type = fieldType;
        }

        void set(String value){
            if(type.equals(String.class)){
                stringValue = value;
            }
            else {
                intValue = Integer.parseInt(value);
            }
        }
    }

    private List<Field> fields = new ArrayList<>();

    private Field addField(Field field){
        fields.add(field);
        return field;
    }

    // This solution relies on adding fields in the order they'll be retrieved in the cursor.  
    // Other options are possible such as a map by column index.
    private Field ticketNumber = addField(new Field(Integer.class));
    private Field serviceName = addField(new Field(String.class));

    public Ticket(Cursor cursor){
        for(int i=0; i < fields.size(); i++){
            Field f = fields.get(i);
            f.set(cursor.getString(i));
        }
    }
}

public int getTicketNumber(){
    return ticketNumber.intValue;
}

// Don't know if you need setters
public void setTicketNumber(int value){
    ticketNumber.intValue = value;
}

// etc for remaining fields