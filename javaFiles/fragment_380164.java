List<Field> fields = new ArrayList<Field>();
for(int i=0; i<e.size(); i++)
{
    if (e.get(i) instanceof Field)
    {
        fields.add(e.get(i));
        // or maybe call methods specific to Field objects
        // ((Field) e.get(i)).specificMethod();
    }
}