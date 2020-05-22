//see https://bedrockminer.jimdo.com/modding-tutorials/advanced-modding/gui-screen/ for some reference
private static boolean FastForwardEnabled = false;
protected void actionPerformed(GuiButton button) throws IOException {
    if (button == AdvanceButton) { //Example GUI Button used as an enable/disable
        FastForwardEnabled = !FastForwardEnabled;
        while (FastForwardEnabled){
            //Example value used; increases game speed 2x
            ChangeTickRate.updateClientTickrate(40);
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 0, 1));
        }
    }
}