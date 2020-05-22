function ja = build_int_array

mynums = { 1:2, 1:5, 1:7 };
% Create a Java array of arrays
dummy = java.lang.Object();
ja = java.lang.reflect.Array.newInstance(dummy.getClass(), numel(mynums));
for i = 1:numel(mynums)
    test.JavaArrayBuilder.assignIntArray(ja, i-1, mynums{i});
end
% Now you have a Java ragged array, albeit as Object[] instead of int[][]