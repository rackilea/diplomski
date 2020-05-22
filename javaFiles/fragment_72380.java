#macro( springFormSingleSelect $path $options $attributes )
    #springBind($path)
    <select id="${status.expression}" name="${status.expression}" ${attributes}>
        #foreach($option in $options.keySet())
            <option value="${option}"
            #if("$!status.value" == "$option")
                selected="selected"
            #end>
            ${options.get($option)}</option>
        #end
    </select>
#end