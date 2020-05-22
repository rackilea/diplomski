Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
float spacingMultiplier = 1;
float spacingAddition = 0;
boolean includePadding = false;

StaticLayout myStaticLayout = new StaticLayout(text, myTextView.getPaint(), myTextView.getWidth(), alignment, spacingMultiplier, spacingAddition, includePadding);

float height = myStaticLayout.getHeight();