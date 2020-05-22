float x = 0.0f;
float y = 0.0f;
float z = 0.0f;
GL11.glTranslatef(x, y, z);
while(Keyboard.next()) {
    if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
        System.out.println("SPACE KEY IS DOWN");
        x += 1.0f;
        y += 1.0f;
        z += 1.0f;
}