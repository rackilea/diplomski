ArrayList<Attribute> atts = new ArrayList<Attribute>();
List<Instance> instances = new ArrayList<Instance>();
for(int dim = 0; dim < numDimensions; dim++)
{
    Attribute current = new Attribute("Attribute" + dim, dim);
    if(dim == 0)
    {
        for(int obj = 0; obj < numInstances; obj++)
        {
            instances.add(new SparseInstance(numDimensions));
        }
    }

    for(int obj = 0; obj < numInstances; obj++)
    {
        instances.get(obj).setValue(current, data[dim][obj]);
    }

    atts.add(current);
}

Instances newDataset = new Instances("Dataset", atts, instances.size());

for(Instance inst : instances)
    newDataset.add(inst);