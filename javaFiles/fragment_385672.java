package org.mule.transport.file;

import org.mule.api.MuleException;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.endpoint.InboundEndpoint;
import org.mule.api.lifecycle.CreateException;
import org.mule.api.transport.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PatchedFileMessageReceiver extends FileMessageReceiver
{
    private static final Logger log = LoggerFactory.getLogger(PatchedFileMessageReceiver.class);

    /**
     *
     * @param connector
     * @param flowConstruct
     * @param endpoint
     * @param readDir
     * @param moveDir
     * @param moveToPattern
     * @param frequency
     * @throws CreateException
     */
    public PatchedFileMessageReceiver(Connector connector, FlowConstruct flowConstruct, InboundEndpoint endpoint, String readDir, String moveDir, String moveToPattern, long frequency) throws CreateException
    {
        super(connector, flowConstruct, endpoint, readDir, moveDir, moveToPattern, frequency);
    }

    /**
     *
     * @return
     * @throws MuleException
     */
    @Override
    List<File> listFiles() throws MuleException
    {
        List<File> list = super.listFiles();

        if(list.isEmpty()) {
            log.trace("List of files is empty, I'm gonna return a new empty ArrayList");
        }

        return ( list.isEmpty() ? new ArrayList<File>() : list );
    }
}