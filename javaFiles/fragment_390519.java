public delegate void HcodecWeightDelegate(int[] block, int block_offset, int stride, int log2_denom, int weight, int offset);
public delegate void HcodecBiweightDelegate(int[] dst, int dst_offset, int[] src, int src_offset, int stride, int log2_denom, int weightd, int weights, int offset);

public HcodecBiweightDelegate[] WeightHcodecPixelsTab = new HcodecBiweightDelegate[] {
    (block, block_offset, stride, log2_denom, weight, offset) => {
        weight_hcodec_pixels_c(16, 16, block, block_offset, stride, log2_denom, weight, offset);
    }
,   (block, block_offset, stride, log2_denom, weight, offset) => {
        weight_hcodec_pixels_c(16, 8, block, block_offset, stride, log2_denom, weight, offset);
    }
};