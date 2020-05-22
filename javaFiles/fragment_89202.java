RichPathView pathView = findViewById(R.id.richPathView);

RichPath[] paths = new RichPath[6];

for (int i = 0; i < paths.length; i++) {
    paths[i] = pathView.findRichPathByIndex(i);
}

RichPathAnimator
    .animate(paths)
    .trimPathEnd(0, 1)
    .duration(1600)
    .start();