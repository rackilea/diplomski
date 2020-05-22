KettleEnvironment.init();
TransMeta metaData = new TransMeta("C:\\examplepath\\test.ktr");

Trans transformation = new Trans(metaData);
transformation.execute(null);
transformation.waitUntilFinished();
...