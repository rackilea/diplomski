import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

HTMLEditorKit kit = new HTMLEditorKit();
jEditorPane.setEditorKit(kit);

URL url = new URL(location of your stylesheet);
StyleSheet styleSheet = new StyleSheet();
styleSheet.importStyleSheet(url)
kit.setStyleSheet(styleSheet);