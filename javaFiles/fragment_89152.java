SceneObject[] scenes = { new Loading(), new Menu() };

...

for (SceneObject scene : scenes) {
    scene.foo();
    scene.bar();
}