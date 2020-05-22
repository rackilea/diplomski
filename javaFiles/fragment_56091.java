<zk>
  <window mode="overlapped" title="win one" border="normal" width="200px" height="150px">
    <attribute name="onMove"><![CDATA[
      ((Label)self.getFirstChild()).setValue("My Zindex is the highest one");
      ((Label)self.getNextSibling().getFirstChild()).setValue("");
    ]]></attribute>
    <attribute name="onClick"><![CDATA[
      ((Label)self.getFirstChild()).setValue("My Zindex is the highest one");
      ((Label)self.getNextSibling().getFirstChild()).setValue("");
    ]]></attribute>
    <label value="" />
  </window>
  <window mode="overlapped" title="win two" border="normal" width="200px" height="150px">
    <attribute name="onMove"><![CDATA[
      ((Label)self.getFirstChild()).setValue("My Zindex is the highest one");
      ((Label)self.getPreviousSibling().getFirstChild()).setValue("");
    ]]></attribute>
    <attribute name="onClick"><![CDATA[
      ((Label)self.getFirstChild()).setValue("My Zindex is the highest one");
      ((Label)self.getPreviousSibling().getFirstChild()).setValue("");
    ]]></attribute>
    <label value="" />
  </window>
</zk>