final int chunk = 10;
final float B_SIZE = 1.0f;

for (int x = 0; x < chunk; x++) {
    for (int y = 0; y < chunk; y++) {
        for (int z = 0; z < chunk; z++) {
            GL11.glPushMatrix();
            GL11.glTranslatef(x*B_SIZE, y*B_SIZE, z*B_SIZE);
            block.render();
            GL11.glPopMatrix();
        }
    }
}