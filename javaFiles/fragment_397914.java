static final int DOWNLOAD_BTN = 0;
static final int OPEN_FILE_BTN = 1;
static final int PROGRESS = 2;
static final int ERROR_MSG = 3;
static final int DOWNLOAD_WHEN_RDY = 4;
static final int ELEMENT_COUNT = 5;
...
boolean[] visibility = new boolean[ELEMENT_COUNT];
...
if (visibility[ERROR_MSG]) {
    ...
}