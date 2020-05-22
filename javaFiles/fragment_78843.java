ABC abc = new ABC();
XYZ xyz = new XYZ();
if(i==1) {
   ROOTPanel.get("panel").add(abc);
} else {
   ROOTPanel.get("panel").add(xyz);
}
if(ROOTPanel.get("panel").getWidgetIndex(abc) != -1) {
   // You know ABC was added
}