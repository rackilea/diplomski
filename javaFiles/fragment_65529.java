/**
 * Takes the specified input field's title and sets it as the field's value.
 *
 * @param elementId ID of an input element
 */
function copyExactValueFromTitle(elementId) {
    if (!elementId) {
        return;
    }
    var input = $('#' + elementId);
    var exactValue = input.attr("title");
    if (exactValue) {
        input.val(exactValue);
    }
}