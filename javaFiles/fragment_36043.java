store=new JsonRest({ handleAs: 'json', target: 
                    '{pathToServices}/rest/services/getSearchResults'});
grid = new EnhancedGrid({
        id: "gridId",
        store: new ObjectStore({ objectStore: store}),
        structure: getGridStructure(),
        plugins: {
            pagination: {
                pageSizes: ["25", "50", "100"],
                description: true,
                sizeSwitch: true,
                pageStepper: true,
                gotoButton: true,
                maxPageStep: 4,
                position: "bottom"},
        }
    });