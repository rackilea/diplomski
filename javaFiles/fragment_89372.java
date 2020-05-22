@import "../valo/valo.scss";

@mixin mytheme {
    @include valo;

    .v-menubar-custom {
        @include valo-menubar($primary-stylename: v-menubar, $include-additional-styles: false);
    }
}