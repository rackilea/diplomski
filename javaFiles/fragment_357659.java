function out = mlength(x)
%MLENGTH Array length, ignoring Java length() methods

% Test for isjava to avoid ignoring overriden length() methods in Matlab objects
if isjava(x)
   out = builtin('length', x);
else
   out = length(x);
end