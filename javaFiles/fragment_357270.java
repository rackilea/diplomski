package org.springframework;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectJAnnotation {

    protected long starttime;
    protected long endtime;
    protected  ExecutionVaribale methodlevleinformation=new ExecutionVaribale();
    protected   List<ExecutionVaribale> liststore = new ArrayList<ExecutionVaribale>(); 







    @Before("execution(* *.*())") // this will call on before every method call on spring framework Or you can change it depending on which spring package method you can to monitor
    public void beforeAnymethodcall(final JoinPoint thisJoinPoint) {


        starttime = System.currentTimeMillis();
        methodlevleinformation.setMethodname(thisJoinPoint.getStaticPart().getSignature().getName());
    }

    @After("execution(* *.*())") // this will call on after every method call on spring framework Or you can change it depending on which spring package method you can to monitor
    public void afterAnymethodcall(final JoinPoint thisJoinPoint) {
        endtime = System.currentTimeMillis();

        methodlevleinformation.setDifferenetime((starttime - endtime)/ 1000); // time in secs
        liststore.add(methodlevleinformation);
        // at last you can iterate list and see the results .Hope this will provide a fine grain information on time taken by spring framework 




    }

     class ExecutionVaribale{


        /**
         * @return the differenetime
         */
        public long getDifferenetime() {
            return differenetime;
        }
        /**
         * @param differenetime the differenetime to set
         */
        public void setDifferenetime(long differenetime) {
            this.differenetime = differenetime;
        }
        /**
         * @return the methodname
         */
        public String getMethodname() {
            return methodname;
        }
        /**
         * @param methodname the methodname to set
         */
        public void setMethodname(String methodname) {
            this.methodname = methodname;
        }

        protected long differenetime;
        protected String  methodname;
    }


}