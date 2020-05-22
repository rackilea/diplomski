function chunkDunzip(Z)
%% Imports:
import com.mathworks.mlwidgets.io.InterruptibleStreamCopier
%% Definitions:
MAX_CHUNK = 100*1024*1024; % 100 MB, just an example
%% Split to chunks:
nChunks = ceil(numel(Z)/MAX_CHUNK);
chunkBounds = round(linspace(0, numel(Z), max(2,nChunks)) );

V = java.util.Vector();
for indC = 1:numel(chunkBounds)-1
  V.add(java.io.ByteArrayInputStream(Z(chunkBounds(indC)+1:chunkBounds(indC+1))));
end

S = java.io.SequenceInputStream(V.elements);  
b = java.util.zip.InflaterInputStream(S);

isc = InterruptibleStreamCopier.getInterruptibleStreamCopier;
c = java.io.FileOutputStream(java.io.File('D:\outFile.bin'));
isc.copyStream(b,c);
c.close();

end