import java.util.Comparator;

import org.csi.domain.core.batch.JoinByComparisonOperator;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class JoinTest
{
   public static void main (String[] args)
   {
      final Observable<Integer> myLeft    = Observable.range (1, 10000000);
      final Observable<Integer> myRight   = Observable.range (-100, 10000000);

      myLeft
         .lift (new JoinByComparisonOperator <Integer, Integer[]> (
            // The stream to be joined
            myRight,
            // The scheduler to use for the new stream
            Schedulers.newThread (),
            // The comparator to use to determine relative equality
            new Comparator<Integer>()
            {
               public int compare (Integer aArg0, Integer aArg1)
               {
                  return aArg0.compareTo (aArg1);
               }
            },
            // The function that combines matches found.
            new Func2<Integer, Integer, Observable<Integer[]>>()
            {
               public Observable<Integer[]> call (Integer aT1, Integer aT2)
               {
                  return Observable.just (new Integer[] {aT1, aT2});
               }
            }
         ))
         // The subscriber outputs the result to the console
         .subscribe (new Action1<Integer[]> ()
         {
            public void call (Integer[] aT)
            {
               System.out.printf ("%d, %d\n", aT[0], aT[1]);
            }
         });

   }
}