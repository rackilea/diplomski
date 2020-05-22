#toolbar .button {
    -size: 20px;
    -fx-padding: 2px;
    -fx-background-color: null;

    -fx-min-width: -size;
    -fx-min-height: -size;
    -fx-pref-width: -size;
    -fx-pref-height: -size;
}

#toolbar .button .shape {
    -fx-background-color: #ecf0f1;
}

#toolbar .button:pressed .shape {
    /* different background for pressed button */
    -fx-background-color: lightgreen;
}

#exit .shape {
    -fx-shape: "M193.94 256L296.5 153.44l21.15-21.15c3.12-3.12 3.12-8.19 0-11.31l-22.63-22.63c-3.12-3.12-8.19-3.12-11.31 0L160 222.06 36.29 98.34c-3.12-3.12-8.19-3.12-11.31 0L2.34 120.97c-3.12 3.12-3.12 8.19 0 11.31L126.06 256 2.34 379.71c-3.12 3.12-3.12 8.19 0 11.31l22.63 22.63c3.12 3.12 8.19 3.12 11.31 0L160 289.94 262.56 392.5l21.15 21.15c3.12 3.12 8.19 3.12 11.31 0l22.63-22.63c3.12-3.12 3.12-8.19 0-11.31L193.94 256z";
}

#max .shape {
    -fx-shape: "M464 32H48C21.5 32 0 53.5 0 80v352c0 26.5 21.5 48 48 48h416c26.5 0 48-21.5 48-48V80c0-26.5-21.5-48-48-48zm0 394c0 3.3-2.7 6-6 6H54c-3.3 0-6-2.7-6-6V192h416v234z";
}

#min .shape {
    -fx-background-insets: 6px 0 6px 0; /* use proper area for shape */
    -fx-shape: "M480 480H32c-17.7 0-32-14.3-32-32s14.3-32 32-32h448c17.7 0 32 14.3 32 32s-14.3 32-32 32z";
}