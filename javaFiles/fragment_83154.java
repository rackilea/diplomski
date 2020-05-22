DynamicForm form = new DynamicForm();
form.setTitleSuffix("");
form.setIsGroup(true);
form.setGroupTitle("DETALLES DEL PLAN");
form.setWidth(720);
form.setColWidths("150","200","150","200");
form.setNumCols(4);

StaticTextItem planT  = new StaticTextItem("Nombre de Plan");
planT.setTitleOrientation(TitleOrientation.LEFT);
planT.setStartRow(true);
planT.setEndRow(true);
planT.setValue("Plan B");

SelectItem tcSelect = new SelectItem("Tipo de Carte");
tcSelect.setTitleOrientation(TitleOrientation.LEFT);
tcSelect.setStartRow(true);

SelectItem peSelect = new SelectItem("Periodo");
peSelect.setTitleOrientation(TitleOrientation.LEFT);
peSelect.setEndRow(true);

TextAreaItem deText = new TextAreaItem("Descripcion del Plan");
deText.setTitleOrientation(TitleOrientation.LEFT);
deText.setStartRow(true);
deText.setEndRow(true);
deText.setColSpan(3);

form.setItems(planT,tcSelect,peSelect,deText);

addMember(form);