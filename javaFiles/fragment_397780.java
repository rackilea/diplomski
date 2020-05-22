public TestReferencePointXMLReaderGUI()
{
    initComponents();
    ReferencePointReader referencePointReader = new ReferencePointReader("path to your xml file");

    List<ReferencePointObject> listOfData = referencePointReader.getData();
    DefaultComboBoxModel<ReferencePointObject> model =
        (DefaultComboBoxModel<ReferencePointObject>) jComboBoxRefPointSelector.getModel();
    for (ReferencePointObject referencePointObject : listOfData)
    {
        model.addElement(referencePointObject);
    }

}