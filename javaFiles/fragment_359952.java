List<String> options = new ArrayList<String>();
options.add("Option 1");
options.add("Option 2");
options.add("Option 3");

ListBox combo = new ListBox();
SelectElement selectElm = combo.getElement().cast();
OptGroupElement groupElement =Document.get().createOptGroupElement();
groupElement.setLabel("category 1");

for (String option : options) 
{
    OptionElement optElement = Document.get().createOptionElement();
    optElement.setInnerText(option.getName());
    groupElement.appendChild(optElement);
}

selectElm.appendChild(groupElement);