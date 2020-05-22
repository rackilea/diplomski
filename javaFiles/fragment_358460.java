@mixin mytheme {
  @include valo;
  // Insert your own theme rules here

  .v-table [class*="-row-no-background"].v-selected {
    background: transparent none; // no colour & no image
    color: black;                 // make the text visible as default selection makes it white
  }
}