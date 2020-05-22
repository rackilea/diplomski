$(document).ready(
        function() {
            // Makes sure the dataTransfer information is sent when we
            // Drop the item in the drop box.
            jQuery.event.props.push('dataTransfer');

            // As far as i know Firefox needs to cancel this event (otherwise it
            // opens
            // dropped files in the browser)
            $('#dropContainer').attr('ondragover', "return false");

            $('#dropContainer').bind(
                    'drop',
                    function(e) {
                        // Files that have been dragged into the drop area
                        var files = e.dataTransfer.files;

                        // Upload each file
                        $.each(files, function(i, file) {
                            var reader = new FileReader();

                            reader.onload = function(input) {
                                var fileName = "fileName:" + file.name + ";";
                                var base64data = input.target.result;

                                $.ajax({
                                    url : $('#dropContainer').attr(
                                            'my:dropcontainer.callback'),
                                    type : 'post',
                                    cache : false,
                                    // Add date before raw base64 file data
                                    data : fileName + base64data,
                                    processData : false,
                                    contentType : false,
                                });
                            };

                            // decode into base64
                            reader.readAsDataURL(file);
                        });
                        return false;
                    });

            // Using little dragging hack because of the HTML5 spec problem
            // URL:
            // http://www.quirksmode.org/blog/archives/2009/09/the_html5_drag.html
            // works like:

            // <parent element>
            // dragging = 0
            // <drop_container>
            // dragging = 1
            // <child>
            // dragging = 2
            // </child>
            // dragging = 1
            // </drop_container>
            // dragging = 0
            // </parent element>

            var dragging = 0;
            $('#dropContainer').bind('dragenter', function() {
                dragging++;
                setHoverDropContainer();
                return false;
            });

            $('#dropContainer').bind('dragleave', function() {
                dragging--;
                if (dragging === 0) {
                    resetHoverDropContainer();
                }
                return false;
            });

            $('#dropContainer').bind('drop', function() {
                dragging = 0; // reset dragging hack
                resetHoverDropContainer();
                return false;
            });
        });

    function setHoverDropContainer() {
        // change colors with smooth transition
        setCSS('#dropContainer', {
            'border-color' : '#0000FF',
            'background-color' : '#EDF4FE',
            '-webkit-transition' : 'background-color 0.6s ease',
            '-moz-transition' : 'background-color 0.6s ease',
            '-o-transition' : 'background-color 0.6s ease',
            'transition' : 'background-color 0.6s ease',
            '-webkit-transition' : 'border-color 0.6s ease',
            '-moz-transition' : 'border-color 0.6s ease',
            '-o-transition' : 'border-color 0.6s ease',
            'transition' : 'border-color 0.6s ease'
        });
    }

    function resetHoverDropContainer() {
        // change colors with smooth transition
        setCSS('#dropContainer', {
            'border-color' : '#C9C9C9',
            'background-color' : '#FFFFFF',
            '-webkit-transition' : 'background-color 0.6s ease',
            '-moz-transition' : 'background-color 0.6s ease',
            '-o-transition' : 'background-color 0.6s ease',
            'transition' : 'background-color 0.6s ease',
            '-webkit-transition' : 'border-color 0.6s ease',
            '-moz-transition' : 'border-color 0.6s ease',
            '-o-transition' : 'border-color 0.6s ease',
            'transition' : 'border-color 0.6s ease'
        });
    }

    function setCSS(element, values) {
        $(element).css(values);
    }
}