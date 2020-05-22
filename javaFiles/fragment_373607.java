package net.earcam.example.servicecomponent.internal;

import java.util.concurrent.atomic.AtomicLong;

import net.earcam.example.servicecomponent.SequenceService;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;

/**
 * @author caspar
 */
@Component
@Service
public class SequenceServiceImp implements SequenceService {

    private AtomicLong sequence;


    @Override
    public long next()
    {
        return sequence.incrementAndGet();
    }


    @Activate
    protected void activate()
    {
        sequence = new AtomicLong();
    }


    @Deactivate
    protected void deactivate()
    {
        sequence = null;
    }
}