@AfterReturning(value="execution(* *..*Repository.*(..))",returning="list")
      public void decrypt(List list) throws Exception
        {
            //Do decryption here for the names inside the list
        }

    }