class Type
{
    private final String    m_name;

    Type(String name)
    {
        m_name = name;
    }

    public String toString()
    {
        return "Type " + m_name;
    }
}

Type type1 = new Type("1");
Type type2 = new Type("2");
ComboViewer comboViewer = new ComboViewer(combo);
comboViewer.setContentProvider(new ArrayContentProvider());
comboViewer.setInput(new Type[] {type1, type2};
comboViewer.setSelection(new StructuredSelection(type1));