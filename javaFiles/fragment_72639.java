recentDirs.setRenderer(new ComboTextRenderer(recentDirs));

...

static private class ComboTextRenderer
extends DefaultListCellRenderer
implements SwingConstants
{
JComponent                          parent;
int                                 renderWidth;

ComboTextRenderer(JComponent par) {
    super();

    parent=par;
    renderWidth=-1;
    }

public void paint(Graphics gc) {
    String                          txt=getText();

    int                             len=txt.length();
    int                             wid=getSize().width;
    Insets                          ins=getInsets();
    FontMetrics                     met=gc.getFontMetrics();

    if(renderWidth==-1 || wid<parent.getSize().width) { renderWidth=wid; }
    else                                              { wid=renderWidth; }
    wid-=(ins.left+ins.right);

    if(met.stringWidth(txt)>wid) {
        String rpl=null;
        for(int xa=0,pfx=Math.min(15,((len/2)-1)),sfx=(pfx+2); pfx>0 && sfx<len; xa++) {
            rpl=(txt.substring(0,pfx)+" ... "+txt.substring(sfx));
            if(met.stringWidth(rpl)<=wid) { break; }
            rpl=null;
            if     ((len-sfx)>15) { sfx++; }
            else if((xa%2)==0   ) { pfx--; }
            else                  { sfx++; }
            }
        if(rpl!=null) { setText(rpl); }
        }

    super.paint(gc);
    }
}