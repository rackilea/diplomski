public Beer(String name, int color, int icon)
{
    this.name = name;
    this.color = color;
    this.icon = context.getResources().getDrawable(icon);
}