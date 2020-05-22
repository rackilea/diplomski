public int availableProcessors()
Returns the number of processors available to the Java virtual machine.
This value may change during a particular invocation of the virtual machine. Applications that are sensitive to the number of available processors should therefore occasionally poll this property and adjust their resource usage appropriately.

Returns:
the maximum number of processors available to the virtual machine; never smaller than one
Since:
1.4