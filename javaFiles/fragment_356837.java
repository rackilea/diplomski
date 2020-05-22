Range r = u.getRange();
StyleSheet ss = r._doc.getStyleSheet();

Paragraph p1 = r.getParagraph(0);
CharacterRun c1a = p1.getCharacterRun(0);

assertEquals("Normal", ss.getStyleDescription(c1a.getStyleIndex()).getName());