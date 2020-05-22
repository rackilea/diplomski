float w = Gdx.graphics.getWidth();
float h = Gdx.graphics.getHeight();
Vector2 cp[] = new Vector2[]{
    new Vector2(0, 0), new Vector2(w * 0.25f, h * 0.5f), new Vector2(0, h), new Vector2(w*0.5f, h*0.75f),
    new Vector2(w, h), new Vector2(w * 0.75f, h * 0.5f), new Vector2(w, 0), new Vector2(w*0.5f, h*0.25f)
};
CatmullRomSpline<Vector2> path = new CatmullRomSpline<Vector2>(cp, true);