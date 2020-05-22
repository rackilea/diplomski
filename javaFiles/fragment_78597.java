package br.com.ciss.cissmart.client.core;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.Resource;
import javax.enterprise.concurrent.LastExecution;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.concurrent.Trigger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationSchedulerX {

@Resource( lookup = "java:jboss/ee/concurrency/scheduler/MyScheduler" )
private ManagedScheduledExecutorService timerService;

private List<ScheduledFuture<?>> scheduledTasks;

/**
 * Método executado no start do servidor.
 *
 * @param o
 *             - {@link javax.servlet.ServletContext} - Contendo as configurações da aplicação
 */
public void init( @Observes @Initialized( ApplicationScoped.class ) Object o ) {

    this.scheduledTasks = Collections.synchronizedList(new ArrayList<ScheduledFuture<?>>());

    ScheduledFuture task =  timerService.schedule( () -> {


        System.out.println( "Run scheduler... " );

    }, new Trigger() {

        @Override
        public Date getNextRunTime( LastExecution le, Date date ) {
            return getNextDateBySeconds( 60 );
        }

        @Override
        public boolean skipRun( LastExecution le, Date date ) {
            return false;
        }

    } );

    scheduledTasks.add( task );

}

private Date getNextDateBySeconds( long seconds ) {
    LocalDateTime ldt = LocalDateTime.now().plusSeconds( seconds );
    return Date.from( ldt.atZone( ZoneId.systemDefault() ).toInstant() );
}

public void destroy( @Observes @Destroyed( ApplicationScoped.class ) Object o ) {

    // Cancel any scheduled tasks, ensuring that the map is locked.
    synchronized ( this.scheduledTasks ) {
        Iterator<ScheduledFuture<?>> i = this.scheduledTasks.iterator();

        while ( i.hasNext() ) {
            ScheduledFuture<?> future = i.next();
            // Cancel the task.
            future.cancel( true );
        }
    }
    this.scheduledTasks.clear();
    this.scheduledTasks = null;

}
}