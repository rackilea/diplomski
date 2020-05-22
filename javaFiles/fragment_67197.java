package com.factor3.app;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import javax.annotation.Nullable;

@Controller("/testserv")
public class TempTestService
{
    // this empty constructor isn't necessary, but
    // also doesn't cause a problem...
   public TempTestService()
   {
   }

   @Get("/{?theData}")
   @Produces(MediaType.TEXT_PLAIN)
   public String performService(@Nullable String theData)
   {
       return "Returning: "+theData;
   }
}