browserSync: {
    dev: {
        bsFiles: {
            src : [
                ...
            ]
        }
    },
    options: {
        watchTask: true,
        proxy: "localhost:8080"
    }
},