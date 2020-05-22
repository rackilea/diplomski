@SideOnly(Side.CLIENT)
@SubscribeEvent(priority = EventPriority.NORMAL)
public void onRenderExperienceBar(RenderGameOverlayEvent event) {

mcObject.fontRenderer.drawStringWithShadow("Hello World", 4, 4, 0xffFFFFFF);
mcObject.ingameGUI.drawRect(2 /*X*/, 2 /*Y*/, 100 /*X1*/, 12 /*Y1*/, 0x80000000 /*COLOUR*/);

}