import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * This class is an operator which can be used to join two {@link Observable} streams,
 * by matching them up using a {@link Comparator}. The two streams need to be sorted
 * according to the rules of the {@link Comparator} for this to work.
 * <p>
 * If the main stream is empty this might never get invoked even if the right stream
 * has data.
 */
public class JoinByComparisonOperator<I, R> implements Observable.Operator<R, I>
{

   private final RightSubscriber<I> subscriberRight;

   private final Comparator<I> comparator;

   private final Func2<I, I, Observable<R>> resultSelector;

  /**
   * The constructor for this class.
   * <p>
   * @param aRight
   *     The observable that is joined to the "right"
   * @param aScheduler
   *     The scheduler used to run the "right" Observable as it always needs to
   *     run on a new thread.
   * @param aComparator
   *     The comparator used to compare two input values. This should follow the
   *     same rules by which the two input streams are sorted
   * @param aResultSelector
   *     Function that gets two matching results and can handle them accordingly.
   *     Note the inputs can be null in case there was no match.
   */
   public JoinByComparisonOperator(
      final Observable<I>              aRight,
      final Scheduler                  aScheduler,
      final Comparator<I>              aComparator,
      final Func2<I, I, Observable<R>> aResultSelector
   )
   {
      subscriberRight   = new RightSubscriber<> ();
      comparator        = aComparator;
      resultSelector    = aResultSelector;

      aRight
         .subscribeOn (aScheduler)
         .subscribe (subscriberRight);
   }

   /**
    * Creates a new subscriber that gets called and passes on any calls in turn.
    * 
    * @param aSubscriber
    * @return
    * <p>
    * @see rx.functions.Func1#call(java.lang.Object)
    */
   @Override
   public Subscriber<? super I> call (final Subscriber<? super R> aSubscriber)
   {
      return new LeftSubscriber (aSubscriber);
   }


   /**
    * The subscriber for the "left" stream, which is the main stream we are operating
    * on.
    */
   private class LeftSubscriber extends Subscriber<I>
   {

      final Subscriber<? super R> nextSubscriber;

      private I nextRight;

      public LeftSubscriber (final Subscriber<? super R> aNextSubscriber)
      {
         nextSubscriber = aNextSubscriber;
      }

      private void selectResultInternal (I aLeft, I aRight)
      {
         resultSelector.call (aLeft, aRight).subscribe (new Action1<R>()
         {
            public void call (R aInput)
            {
               nextSubscriber.onNext (aInput);
            }
         });
      }

      @Override
      public void onCompleted ()
      {
         if (!nextSubscriber.isUnsubscribed ())
         {
            while (!subscriberRight.isComplete () || nextRight != null)
            {
               try
               {
                  I myNext = null;

                  if (nextRight != null)
                  {
                     myNext = nextRight;
                     nextRight = null;
                  }
                  else
                  {
                     myNext = subscriberRight.takeNext ();
                  }

                  if (myNext != null)
                  {
                     selectResultInternal (null, myNext);
                  }
               }
               catch (InterruptedException myException)
               {
                  onError (myException);
               }
            }

            nextSubscriber.onCompleted ();
         }
      }

      @Override
      public void onError (Throwable aE)
      {
         if (!nextSubscriber.isUnsubscribed ())
         {
            nextSubscriber.onCompleted ();

            subscriberRight.unsubscribe ();
         }
      }

      @Override
      public void onNext (I aInput)
      {
         if (!nextSubscriber.isUnsubscribed ())
         {
            I myRight   = null;
            I myLeft    = aInput;

            if (subscriberRight.getError () != null)
            {
               nextSubscriber.onError (subscriberRight.getError ());
               unsubscribe ();
            }

            if (!subscriberRight.isComplete ())
            {
               int myComparison = 0;

               do {

                  if (nextRight == null)
                  {
                     try
                     {
                        nextRight = subscriberRight.takeNext ();
                     }
                     catch (InterruptedException myException)
                     {
                        onError (myException);
                        return;
                     }
                  }

                  if (nextRight != null)
                  {
                     myComparison   = Objects.compare (nextRight, aInput, comparator);

                     if (myComparison < 0)
                     {
                        selectResultInternal (null, nextRight);
                        nextRight   = null;
                     }
                     else if (myComparison == 0)
                     {
                        myRight     = nextRight;
                        nextRight   = null;
                     }
                  }

               } while (myComparison < 0);
            }

            selectResultInternal (myLeft, myRight);
         }
      }
   }

   /**
    * This class is intended to consume the "right" input stream and buffer the result
    * so it can be retrieved when processing the main stream.
    */
   private class RightSubscriber<T> extends Subscriber<T>
   {

      private boolean complete = false;

      private Throwable error = null;

      private BlockingQueue<T> buffer = new ArrayBlockingQueue <> (1000);

      @Override
      public void onCompleted ()
      {
         complete = true;
      }

      @Override
      public void onError (Throwable aE)
      {
         error = aE;
      }

      @Override
      public void onNext (T aT)
      {
         try {
            buffer.put (aT);
         }
         catch (InterruptedException myException) {
            error = myException;
         }
      }

      public T takeNext() throws InterruptedException
      {
         return buffer.poll (10, TimeUnit.SECONDS);
      }

      public boolean isComplete()
      {
         return complete && buffer.size () == 0;
      }

      public Throwable getError()
      {
         return error;
      }
   };
}