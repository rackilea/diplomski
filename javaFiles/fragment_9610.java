ArrayList<Function> fList = new ArrayList<>();
fList.add(new Function(1));
fList.add(new Function(2));

DefaultListModel<Function> dFuncList = new DefaultListModel();
jList2.setModel(dFuncList);
for(Function f : fList) {
    dFuncList.addElement(f);
}