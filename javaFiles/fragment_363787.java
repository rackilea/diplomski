fd.append('whole', new Blob([JSON.stringify({
        ID: ID,
        name1:file1.name,
        name2:file2.name,
    })], {
        type: "application/json"
    }));