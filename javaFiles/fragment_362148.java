.root{
   -fx-window-border: #444444;
   -fx-window-color: #999999;
   -fx-window-text: #111111;
   -fx-button-color: #555555;
}

.my-pane{
   -fx-border-width: 2px;
   -fx-border-color: -fx-window-border;
   -fx-background-color: -fx-window-color;
   -fx-padding: 10px;
   -fx-spacing: 10px;
}

.my-pane .label{
  -fx-text-fill: -fx-window-text;
  -fx-font-size: 16px;
}

.my-pane .button{
  -fx-base: -fx-button-color;
}