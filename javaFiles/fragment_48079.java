{ $group: { 
    _id: null, 
    original_id: { $first: "$_id" },
    text: { $first: "$array.text" }, 
    value: { $max: "$array.value" } 
} }