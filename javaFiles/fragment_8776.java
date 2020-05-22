groovy.json.JsonOutput.toJson([
    title: title,
    state: "OPEN",
    reviewers: names.collect{ [user: [name: it]] }],
    // ...
])