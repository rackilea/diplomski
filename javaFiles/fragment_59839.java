import java.io.*;
import org.bytedeco.javacpp.*;
import static org.bytedeco.javacpp.avcodec.*;
import static org.bytedeco.javacpp.avformat.*;
import static org.bytedeco.javacpp.avutil.*;
import static org.bytedeco.javacpp.swscale.*;

public class Muxer {

    public class OutputStream {
        public AVStream Stream;
        public AVCodecContext Ctx;

        public AVFrame Frame;

        public SwsContext SwsCtx;

        public void setStream(AVStream s) {
            this.Stream = s;
        }

        public AVStream getStream() {
            return this.Stream;
        }

        public void setCodecCtx(AVCodecContext c) {
            this.Ctx = c;
        }

        public AVCodecContext getCodecCtx() {
            return this.Ctx;
        }

        public void setFrame(AVFrame f) {
            this.Frame = f;
        }

        public AVFrame getFrame() {
            return this.Frame;
        }

        public OutputStream() {
            Stream = null;
            Ctx = null;
            Frame = null;
            SwsCtx = null;
        }

    }

    public static void main(String[] args) throws IOException {
        Muxer t = new Muxer();
        OutputStream VideoSt = t.new OutputStream();
        AVOutputFormat Fmt = null;
        AVFormatContext FmtCtx = new AVFormatContext(null);
        AVCodec VideoCodec = null;
        AVDictionary Opt = null;
        SwsContext SwsCtx = null;
        AVPacket Pkt = new AVPacket();

        int GotOutput;
        int InLineSize[] = new int[1];

        String FilePath = "/path/xxx.mp4";

        avformat_alloc_output_context2(FmtCtx, null, null, FilePath);
        Fmt = FmtCtx.oformat();

        AVCodec codec = avcodec_find_encoder_by_name("libx264");
        av_format_set_video_codec(FmtCtx, codec);

        VideoCodec = avcodec_find_encoder(Fmt.video_codec());
        VideoSt.setStream(avformat_new_stream(FmtCtx, null));
        AVStream stream = VideoSt.getStream();
        VideoSt.getStream().id(FmtCtx.nb_streams() - 1);
        VideoSt.setCodecCtx(avcodec_alloc_context3(VideoCodec));

        VideoSt.getCodecCtx().codec_id(Fmt.video_codec());

        VideoSt.getCodecCtx().bit_rate(5120000);

        VideoSt.getCodecCtx().width(1920);
        VideoSt.getCodecCtx().height(1080);
        AVRational fps = new AVRational();
        fps.den(25); fps.num(1);
        VideoSt.getStream().time_base(fps);
        VideoSt.getCodecCtx().time_base(fps);
        VideoSt.getCodecCtx().gop_size(10);
        VideoSt.getCodecCtx().max_b_frames();
        VideoSt.getCodecCtx().pix_fmt(AV_PIX_FMT_YUV420P);

        if ((FmtCtx.oformat().flags() & AVFMT_GLOBALHEADER) != 0)
            VideoSt.getCodecCtx().flags(VideoSt.getCodecCtx().flags() | AV_CODEC_FLAG_GLOBAL_HEADER);

        avcodec_open2(VideoSt.getCodecCtx(), VideoCodec, Opt);

        VideoSt.setFrame(av_frame_alloc());
        VideoSt.getFrame().format(VideoSt.getCodecCtx().pix_fmt());
        VideoSt.getFrame().width(1920);
        VideoSt.getFrame().height(1080);

        av_frame_get_buffer(VideoSt.getFrame(), 32);

        // should be at least Long or even BigInteger
        // it is a unsigned long in C
        int nextpts = 0;

        av_dump_format(FmtCtx, 0, FilePath, 1);
        avio_open(FmtCtx.pb(), FilePath, AVIO_FLAG_WRITE);

        avformat_write_header(FmtCtx, Opt);

        int[] got_output = { 0 };
        while (still_has_input) {

            // convert or directly copy your Bytes[] into VideoSt.Frame here
            // AVFrame structure has two important data fields: 
            // AVFrame.data (uint8_t*[]) and AVFrame.linesize (int[]) 
            // data includes pixel values in some formats and linesize is size of each picture line.
            // For example, if formats is RGB. linesize should has 3 valid values equaling to `image_width * 3`. And data will point to three arrays containing rgb values.
            // But I guess we'll need swscale() to convert pixel format here. From RGB to yuv420p (or other yuv family formats).

            Pkt = new AVPacket();
            av_init_packet(Pkt);

            VideoSt.getFrame().pts(nextpts++);
            avcodec_encode_video2(VideoSt.getCodecCtx(), Pkt, VideoSt.getFrame(), got_output);

            av_packet_rescale_ts(Pkt, VideoSt.getCodecCtx().time_base(), VideoSt.getStream().time_base());
            Pkt.stream_index(VideoSt.getStream().index());
            av_interleaved_write_frame(FmtCtx, Pkt);

            av_packet_unref(Pkt);
        }

        // get delayed frames
        for (got_output[0] = 1; got_output[0] != 0;) {
            Pkt = new AVPacket();
            av_init_packet(Pkt);

            avcodec_encode_video2(VideoSt.getCodecCtx(), Pkt, null, got_output);
            if (got_output[0] > 0) {
                av_packet_rescale_ts(Pkt, VideoSt.getCodecCtx().time_base(), VideoSt.getStream().time_base());
                Pkt.stream_index(VideoSt.getStream().index());
                av_interleaved_write_frame(FmtCtx, Pkt);
            }

            av_packet_unref(Pkt);
        }

        // free c structs
        avcodec_free_context(VideoSt.getCodecCtx());
        av_frame_free(VideoSt.getFrame());
        avio_closep(FmtCtx.pb());
        avformat_free_context(FmtCtx);
    }
}