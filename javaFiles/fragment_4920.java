import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.MapTileRequestState;
import org.osmdroid.tileprovider.modules.IFilesystemCache;
import org.osmdroid.tileprovider.modules.INetworkAvailablityCheck;
import org.osmdroid.tileprovider.modules.MapTileDownloader;
import org.osmdroid.tileprovider.modules.MapTileModuleProviderBase;
import org.osmdroid.tileprovider.tilesource.BitmapTileSourceBase.LowMemoryException;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.util.StreamUtils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;

/**
 * A drop-in replacement for {@link MapTileDownloader}. This loads tiles from an
 * HTTP or HTTPS server, making use of a custom {@link SSLSocketFactory} for SSL
 * peer verification.
 */
public class MyTileDownloader extends MapTileModuleProviderBase {
    private static final String TAG = "MyMapTileDownloader";

    protected OnlineTileSourceBase mTileSource;
    protected final IFilesystemCache mFilesystemCache;
    protected final INetworkAvailablityCheck mNetworkAvailablityCheck;
    protected final SSLSocketFactory mSSLSocketFactory;

    public MyTileDownloader(ITileSource pTileSource,
            IFilesystemCache pFilesystemCache,
            INetworkAvailablityCheck pNetworkAvailablityCheck,
            SSLSocketFactory pSSLSocketFactory) {
        super(4, TILE_DOWNLOAD_MAXIMUM_QUEUE_SIZE);
        setTileSource(pTileSource);
        mFilesystemCache = pFilesystemCache;
        mNetworkAvailablityCheck = pNetworkAvailablityCheck;
        mSSLSocketFactory = pSSLSocketFactory;
    }

    public ITileSource getTileSource() {
        return mTileSource;
    }

    @Override
    public void setTileSource(final ITileSource tileSource) {
        // We are only interested in OnlineTileSourceBase tile sources
        if (tileSource instanceof OnlineTileSourceBase)
            mTileSource = (OnlineTileSourceBase) tileSource;
        else
            mTileSource = null;
    }

    @Override
    public boolean getUsesDataConnection() {
        return true;
    }

    @Override
    protected String getName() {
        return "Online Tile Download Provider";
    }

    @Override
    protected String getThreadGroupName() {
        return "downloader";
    }

    @Override
    public int getMinimumZoomLevel() {
        return (mTileSource != null ? mTileSource.getMinimumZoomLevel()
                : MINIMUM_ZOOMLEVEL);
    }

    @Override
    public int getMaximumZoomLevel() {
        return (mTileSource != null ? mTileSource.getMaximumZoomLevel()
                : MAXIMUM_ZOOMLEVEL);
    }

    @Override
    protected Runnable getTileLoader() {
        return new TileLoader();
    };

    private class TileLoader extends MapTileModuleProviderBase.TileLoader {
        @Override
        public Drawable loadTile(final MapTileRequestState aState)
                throws CantContinueException {
            if (mTileSource == null)
                return null;

            InputStream in = null;
            OutputStream out = null;
            final MapTile tile = aState.getMapTile();

            try {
                if (mNetworkAvailablityCheck != null
                        && !mNetworkAvailablityCheck.getNetworkAvailable()) {
                    if (DEBUGMODE)
                        Log.d(TAG, "Skipping " + getName()
                                + " due to NetworkAvailabliltyCheck.");
                    return null;
                }

                final String tileURLString = mTileSource.getTileURLString(tile);
                if (DEBUGMODE)
                    Log.d(TAG, "Downloading Maptile from url: " + tileURLString);

                if (TextUtils.isEmpty(tileURLString))
                    return null;

                // Create an HttpURLConnection to download the tile
                URL url = new URL(tileURLString);
                HttpURLConnection connection = (HttpURLConnection) url
                        .openConnection();
                connection.setConnectTimeout(30000);
                connection.setReadTimeout(30000);

                // Use our custom SSLSocketFactory for secure connections
                if ("https".equalsIgnoreCase(url.getProtocol()))
                    ((HttpsURLConnection) connection)
                            .setSSLSocketFactory(mSSLSocketFactory);

                // Open the input stream
                in = new BufferedInputStream(connection.getInputStream(),
                        StreamUtils.IO_BUFFER_SIZE);

                // Check to see if we got success
                if (connection.getResponseCode() != 200) {
                    Log.w(TAG, "Problem downloading MapTile: " + tile
                            + " HTTP response: " + connection.getHeaderField(0));
                    return null;
                }

                // Read the tile into an in-memory byte array
                final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
                out = new BufferedOutputStream(dataStream,
                        StreamUtils.IO_BUFFER_SIZE);
                StreamUtils.copy(in, out);
                out.flush();
                final byte[] data = dataStream.toByteArray();
                final ByteArrayInputStream byteStream = new ByteArrayInputStream(
                        data);

                // Save the data to the filesystem cache
                if (mFilesystemCache != null) {
                    mFilesystemCache.saveFile(mTileSource, tile, byteStream);
                    byteStream.reset();
                }
                final Drawable result = mTileSource.getDrawable(byteStream);
                return result;

            } catch (final UnknownHostException e) {
                Log.w(TAG, "UnknownHostException downloading MapTile: " + tile
                        + " : " + e);
                throw new CantContinueException(e);

            } catch (final LowMemoryException e) {
                Log.w(TAG, "LowMemoryException downloading MapTile: " + tile
                        + " : " + e);
                throw new CantContinueException(e);

            } catch (final FileNotFoundException e) {
                Log.w(TAG, "Tile not found: " + tile + " : " + e);

            } catch (final IOException e) {
                Log.w(TAG, "IOException downloading MapTile: " + tile + " : "
                        + e);

            } catch (final Throwable e) {
                Log.e(TAG, "Error downloading MapTile: " + tile, e);

            } finally {
                StreamUtils.closeStream(in);
                StreamUtils.closeStream(out);
            }
            return null;
        }

        @Override
        protected void tileLoaded(final MapTileRequestState pState,
                final Drawable pDrawable) {
            // Don't return the tile Drawable because we'll wait for the fs
            // provider to ask for it. This prevent flickering when a load
            // of delayed downloads complete for tiles that we might not
            // even be interested in any more.
            super.tileLoaded(pState, null);
        }
    }
}