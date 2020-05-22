// UI element declarations

JCheckBox cbAsia = new JCheckBox("Asia");
cbAsia.addItemListener(this);

JCheckBox cbChina = new JCheckBox("China");

JCheckBox cbIndia = new JCheckBox("India");

JCheckBox cbJapan = new JCheckBox("Japan");

JCheckBox cbPakistan = new JCheckBox("Pakistan");

JCheckBox cbThailand = new JCheckBox("Thailand");

JCheckBox cbVietnam = new JCheckBox("Vietnam");

// Item state handling loop

public void itemStateChanged(ItemEvent e)
{
    Object source = e.getItemSelectable();

    if (source == cbAsia)
    {
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            cbChina.setSelected(true);
            cbIndia.setSelected(true);
            cbJapan.setSelected(true);
            cbPakistan.setSelected(true);
            cbThailand.setSelected(true);
            cbVietnam.setSelected(true);
        }
        else
            cbChina.setSelected(false);
            cbIndia.setSelected(false);
            cbJapan.setSelected(false);
            cbPakistan.setSelected(false);
            cbThailand.setSelected(false);
            cbVietnam.setSelected(false);
        }
    }
}