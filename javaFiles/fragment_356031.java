List<GameObject> objects = GameObjectManager.getGameObjects();
int size = objects.size();
for(int i = 0; i < size; i++) {
    GameObject g = objects.get(i);
    g.update();
}