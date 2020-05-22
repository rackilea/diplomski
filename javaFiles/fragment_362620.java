// onStart
int newTheme = this.getThemeId(this);
if(this.mCurrentTheme != newTheme) {
    this.finish();
    this.startActivity(new Intent(this, this.getClass()));
    return;
}