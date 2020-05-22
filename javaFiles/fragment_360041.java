.button-reflex {
    -fx-background-color1: lightblue;
    -fx-background-color2: aqua;
    -fx-background-color3: blue;
    -fx-shape: "M 200 *a lot of numbers here* Z";
    -fx-background-color: radial-gradient(focus-angle 360deg, focus-distance 0%, center 50% 50%, radius 70%, reflect, -fx-background-color1, -fx-background-color2 30%, -fx-background-color3);
    -fx-text-fill: linear-gradient(#e4e000 0%, #ff0000 50%, #e4e000 100%);
}

.button-reflex:my-hover {
    /* only change colors here; keep the rest */
    -fx-background-color1: dodgerblue;
    -fx-background-color2: deepskyblue;
    -fx-background-color3: darkblue;
}