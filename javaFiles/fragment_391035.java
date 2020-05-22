HashMap<String, String> inst1 = new HashMap(instructorIO.getInstructors());
instListModel = new DefaultListModel<String>();
for (String value : inst1.values())
{
    instListModel.addElement(value);
}