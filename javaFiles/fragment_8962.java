import java.io.File;
import java.io.FileOutputStream;

import ar.com.hjg.pngj.FileHelper;
import ar.com.hjg.pngj.ImageLine;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngReader;
import ar.com.hjg.pngj.PngWriter;
import ar.com.hjg.pngj.chunks.*;

public class ApngSplit {

    private static final String PREFIX = "apngf";

    /** reads a APNG file and tries to split it into its frames */
    public static void process(File orig) throws Exception {
        PngReader pngr = FileHelper.createPngReader(orig);
        File dest = new File(orig.getParent(), PREFIX + "0_" + orig.getName());
        PngWriter pngw = FileHelper.createPngWriter(dest, pngr.imgInfo, true);
        System.out.println("writing default frame " + pngw.getFilename());
        pngr.setChunkLoadBehaviour(ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS);
        pngr.setMaxBytesMetadata(Integer.MAX_VALUE);
        pngr.setMaxTotalBytesRead(Long.MAX_VALUE);
        pngr.setSkipChunkIds(new String[] {});
        int copyPolicy = ChunkCopyBehaviour.COPY_PALETTE | ChunkCopyBehaviour.COPY_ALL_SAFE;
        pngw.copyChunksFirst(pngr, copyPolicy);
        int cols = pngr.imgInfo.cols;
        int channels = pngr.imgInfo.channels;
        for (int row = 0; row < pngr.imgInfo.rows; row++) {
            ImageLine l1 = pngr.readRow(row);
            pngw.writeRow(l1, row);
        }
        pngr.end();
        pngw.copyChunksLast(pngr, copyPolicy);
        pngw.end();
        processExtra2(orig, pngr.getChunksList());
    }

    private static void processExtra2(File orig, ChunksList chunks) throws Exception {
        int numframe = 0;
        FileOutputStream os = null;
        boolean afterIdat = false;
        for (PngChunk chunkApng : chunks.getChunks()) {
            if (chunkApng.id.equals("IDAT"))
                afterIdat = true;
            if (chunkApng.id.equals("fcTL") && afterIdat) {
                numframe++;
                if (os != null)
                    endPng(chunks, os);
                File dest = new File(orig.getParent(), PREFIX + numframe + "_" + orig.getName());
                System.out.println("writing seq " + numframe + " : " + dest);
                os = new FileOutputStream(dest);
                beginPng(chunks, os);
            }
            if (chunkApng.id.equals("fdAT")) {
                ChunkRaw crawf = chunkApng.createRawChunk();
                int seq = PngHelperInternal.readInt4fromBytes(crawf.data, 0);
                ChunkRaw crawi = new ChunkRaw(crawf.len - 4, ChunkHelper.b_IDAT, true);
                System.arraycopy(crawf.data, 4, crawi.data, 0, crawi.data.length);
                crawi.writeChunk(os);
            }
        }
        if (os != null)
            endPng(chunks, os);
    }

    private static void endPng(ChunksList chunks, FileOutputStream fos) throws Exception {
        chunks.getById1(PngChunkIEND.ID).createRawChunk().writeChunk(fos);
        fos.close();
    }

    private static void beginPng(ChunksList chunks, FileOutputStream fos) throws Exception {
        fos.write(new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 }); // signature
        chunks.getById1(PngChunkIHDR.ID).createRawChunk().writeChunk(fos);
        PngChunk plte = chunks.getById1(PngChunkPLTE.ID);
        if (plte != null)
            plte.createRawChunk().writeChunk(fos);
    }

    public static void main(String[] args) throws Exception {
        process(new File("C:/temp/029.png"));
    }

}