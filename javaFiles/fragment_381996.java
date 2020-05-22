<select multiple="multiple" name="RequirementFor" id="RequirementFor" onchange='getMultiple(this);'>
    <option value="1">Test1</option>
    <option value="2">Test2</option>
    <option value="3">Test3</option>
    <option value="4">Test4</option>
</select>

<script>
    var selected; 
    function getMultiple(ob) { 
        selected = new Array();
        for (var i = 0; i < ob.options.length; i++) {
            if (ob.options[ i ].selected) {
                selected.push(ob.options[ i ].value);
            }
        }
        var str = "";
    for (var i = 0; i < selected.length; i++) {
        str += "&value=" + selected[i];
    }
    console.log(str);

            // --> your ajax code

    }

</script>