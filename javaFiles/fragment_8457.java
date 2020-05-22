int containerWidth = container.getElement().getOffsetWidth();
int button1Width = w1.getElement().getOffsetWidth();
int button2Width = w2.getElement().getOffsetWidth();
int button3Width = w3.getElement().getOffsetWidth();

if ( (button1Width + button2Width) > containerWidth ) {
  button1Width = containerWidth;
  if (( button2Width + button3Width ) > containerWidth) {
    button2Width = containerWidth;
  } else {
    button2Width = containerWidth - button3Width;
  }
} else {
  button2Width = containerWidth - button1Width;
}

w1.getElement().getStyle().setWidth(button1Width,Unit.PX);
w2.getElement().getStyle().setWidth(button2Width,Unit.PX);
w3.getElement().getStyle().setWidth(button3Width,Unit.PX);