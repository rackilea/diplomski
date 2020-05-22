FastVector atts = new FastVector();
List<Instance> instances = new ArrayList<Instance>();
for(int dim = 0; dim < numDimensions; dim++)
{
    // Create new attribute / dimension
    Attribute current = new Attribute("Attribute" + dim, dim);
    // Create an instance for each data object
    if(dim == 0)
    {
        for(int obj = 0; obj < numInstances; obj++)
        {
            instances.add(new SparseInstance(numDimensions));
        }
    }

    // Fill the value of dimension "dim" into each object
    for(int obj = 0; obj < numInstances; obj++)
    {
        instances.get(obj).setValue(current, data[dim][obj]);
    }

    // Add attribute to total attributes
    atts.addElement(current);
}

// Create new dataset
Instances newDataset = new Instances("Dataset", atts, instances.size());

// Fill in data objects
for(Instance inst : instances)
    newDataset.add(inst);