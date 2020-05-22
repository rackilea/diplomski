@import "../valo/valo";

// must be outside theme mixin as per https://vaadin.com/wiki/-/wiki/Main/Adding+a+splash+screen
.v-generated-body {
  // change the overflow from hidden to auto
  overflow: auto;
  // copy the rest as it was
  margin: 0;
  padding: 0;
  border: 0;
}

@mixin mytheme {
  @include valo;

  // other customizations
}