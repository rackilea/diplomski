<div data-sly-test.directoryDefault="${properties.directoryDefault == true}" data-sly-unwrap>
    <div data-sly-include="directory.html" data-sly-unwrap />
</div>
<div data-sly-test="${!directoryDefault}" data-sly-unwrap>
    <div data-sly-include="gallery.html" data-sly-unwrap />
</div>