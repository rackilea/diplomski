import ij.gui.GenericDialog

gd = new GenericDialog("FrameDemo Settings")

items = ["Option A", "Option B"]
gd.addRadioButtonGroup("Test", (String[]) items, 2, 1, "0")

gd.showDialog()

if (gd.wasOKed()) {
    answer = gd.getNextRadioButton()
    println answer
}