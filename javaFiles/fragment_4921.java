import javax.net.ssl.SSLSocketFactory;

import org.osmdroid.tileprovider.IMapTileProviderCallback;
import org.osmdroid.tileprovider.IRegisterReceiver;
import org.osmdroid.tileprovider.MapTileProviderArray;
import org.osmdroid.tileprovider.MapTileProviderBasic;
import org.osmdroid.tileprovider.modules.INetworkAvailablityCheck;
import org.osmdroid.tileprovider.modules.MapTileFileArchiveProvider;
import org.osmdroid.tileprovider.modules.MapTileFilesystemProvider;
import org.osmdroid.tileprovider.modules.NetworkAvailabliltyCheck;
import org.osmdroid.tileprovider.modules.TileWriter;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.tileprovider.util.SimpleRegisterReceiver;

import android.content.Context;

/**
 * A drop-in replacement for {@link MapTileProviderBasic}. This top-level tile
 * provider implements a basic tile request chain which includes a
 * {@link MapTileFilesystemProvider} (a file-system cache), a
 * {@link MapTileFileArchiveProvider} (archive provider), and a
 * {@link MyTileDownloader} (downloads map tiles via tile source).
 */
public class MyTileProvider extends MapTileProviderArray implements
        IMapTileProviderCallback {
    public MyTileProvider(final Context pContext, final ITileSource pTileSource) {
        this(new SimpleRegisterReceiver(pContext),
                new NetworkAvailabliltyCheck(pContext), pTileSource, app
                        .getSSLSocketFactory());
    }

    protected MyTileProvider(final IRegisterReceiver pRegisterReceiver,
            final INetworkAvailablityCheck aNetworkAvailablityCheck,
            final ITileSource pTileSource,
            final SSLSocketFactory pSSLSocketFactory) {
        super(pTileSource, pRegisterReceiver);

        // Look for raw tiles on the file system
        final MapTileFilesystemProvider fileSystemProvider = new MapTileFilesystemProvider(
                pRegisterReceiver, pTileSource);
        mTileProviderList.add(fileSystemProvider);

        // Look for tile archives on the file system
        final MapTileFileArchiveProvider archiveProvider = new MapTileFileArchiveProvider(
                pRegisterReceiver, pTileSource);
        mTileProviderList.add(archiveProvider);

        // Look for raw tiles on the Internet
        final TileWriter tileWriter = new TileWriter();
        final MyTileDownloader downloaderProvider = new MyTileDownloader(
                pTileSource, tileWriter, aNetworkAvailablityCheck,
                pSSLSocketFactory);
        mTileProviderList.add(downloaderProvider);
    }
}