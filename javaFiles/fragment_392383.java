dissect { mapping => { "message" => "%{} - %{json}" } }
    if [json] =~ /^{/ {
        json { source => json }
    } else {
        drop {}
    }