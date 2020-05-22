@import "../valo/valo.scss";

@mixin mytheme {
    @include valo;

    @include valo-menubar($primary-stylename: v-menubar-custom, $include-additional-styles: false);
}