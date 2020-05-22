import com.liferay.portlet.documentlibrary.util.ImageProcessorUtil;
import com.liferay.portlet.documentlibrary.util.DLPreviewableProcessor;

for(FileEntry f:l) {
  InputStream thumbnail = ImageProcessorUtil.getThumbnailAsStream(f.getFileVersion(), DLPreviewableProcessor.THUMBNAIL_INDEX_DEFAULT);
}