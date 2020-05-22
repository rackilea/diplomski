const executeJava = () => {
        return new Promise((resolve, reject) => {
            const child = exec('java -jar main.jar', function (error, stdout, stderr) {
                console.log('Value at stdout is: ' + stdout); // here you get your result. In my case I did'nt needed to pass arguments to java program.
                resolve(stdout);
                if (error !== null) {
                    console.log('exec error: ' + error);
                    reject(error);
                }
            });
        })
    }

// you can call this function from your node.js express app using
// const myResult = await executeJava();