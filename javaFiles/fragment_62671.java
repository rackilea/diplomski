/* filled pseudoclass is important here to prevent selection
   of empty rows when no song is playing */
.table-view .table-row-cell:filled:playing {
    -fx-background-color: #FFDC00;
    -fx-border-color: black;
    -fx-text-fill: white;
}