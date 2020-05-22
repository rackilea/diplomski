private byte[] multiply(byte[] x, short xOffset, short xLength, byte[] y,
        short yOffset, short yLength,short tempOutoffset)
{
    normalize();
    //copy x value to temporary rambuffer
    Util.arrayFillNonAtomic(tempBuffer, tempOutoffset,(short) (Configuration.LENGTH_RSAOBJECT_MODULUS+tempOutoffset),(byte)0x00);
    Util.arrayCopy(x, xOffset, tempBuffer, (short)(Configuration.LENGTH_RSAOBJECT_MODULUS - xLength), xLength);

    // copy the y value to match th size of rsa_object
    Util.arrayFillNonAtomic(ram_y, IConsts.OFFSET_START, (short) (Configuration.LENGTH_RSAOBJECT_MODULUS-1),(byte)0x00);
    Util.arrayCopy(y,yOffset,ram_y,(short)(Configuration.LENGTH_RSAOBJECT_MODULUS - yLength),yLength);

    Util.arrayFillNonAtomic(ram_y_prime, IConsts.OFFSET_START, (short) (Configuration.LENGTH_RSAOBJECT_MODULUS-1),(byte)0x00);
    Util.arrayCopy(y,yOffset,ram_y_prime,(short)(Configuration.LENGTH_RSAOBJECT_MODULUS - yLength),yLength);

    Util.arrayFillNonAtomic(ram_x, IConsts.OFFSET_START, (short) (Configuration.LENGTH_RSAOBJECT_MODULUS-1),(byte)0x00);
    Util.arrayCopy(x,xOffset,ram_x,(short)(Configuration.LENGTH_RSAOBJECT_MODULUS - xLength),xLength);

    // if x>y
    if(this.isGreater(ram_x, IConsts.OFFSET_START, Configuration.LENGTH_RSAOBJECT_MODULUS, ram_y,IConsts.OFFSET_START, Configuration.LENGTH_MODULUS)>0)
    {

        // x <- x-y
        JBigInteger.subtract(ram_x,IConsts.OFFSET_START,Configuration.LENGTH_RSAOBJECT_MODULUS, ram_y,
                IConsts.OFFSET_START, Configuration.LENGTH_RSAOBJECT_MODULUS);
    }
    else
    {

        // y <- y-x
        JBigInteger.subtract(ram_y_prime,IConsts.OFFSET_START,Configuration.LENGTH_RSAOBJECT_MODULUS, ram_x,
                IConsts.OFFSET_START, Configuration.LENGTH_MODULUS);
         // ramy stores the (y-x) values copy value to ram_x
        Util.arrayCopy(ram_y_prime, IConsts.OFFSET_START,ram_x,IConsts.OFFSET_START,Configuration.LENGTH_RSAOBJECT_MODULUS);

    }

        //|x-y|2
        mRsaCipherForSquaring.init(mRsaPublicKekForSquare, Cipher.MODE_ENCRYPT);
        mRsaCipherForSquaring.doFinal(ram_x, IConsts.OFFSET_START, Configuration.LENGTH_RSAOBJECT_MODULUS, ram_x,
                IConsts.OFFSET_START); // OK

        // x^2
        mRsaCipherForSquaring.doFinal(tempBuffer, tempOutoffset, Configuration.LENGTH_RSAOBJECT_MODULUS, tempBuffer, tempOutoffset); // OK

        // y^2
        mRsaCipherForSquaring.doFinal(ram_y,IConsts.OFFSET_START, Configuration.LENGTH_RSAOBJECT_MODULUS, ram_y,IConsts.OFFSET_START); //OK 



        if (JBigInteger.add(ram_y, IConsts.OFFSET_START, Configuration.LENGTH_MODULUS, tempBuffer, tempOutoffset,
                Configuration.LENGTH_MODULUS)) {
              // y^2 + x^2 
            JBigInteger.subtract(ram_y, IConsts.OFFSET_START, Configuration.LENGTH_MODULUS, tempBuffer,
                    Configuration.TEMP_OFFSET_MODULUS, Configuration.LENGTH_MODULUS);
        } 


        //  x^2 + y^2
        if (JBigInteger.subtract(ram_y, IConsts.OFFSET_START, Configuration.LENGTH_MODULUS, ram_x, IConsts.OFFSET_START,
                Configuration.LENGTH_MODULUS)) {

            JBigInteger.add(ram_y, IConsts.OFFSET_START, Configuration.LENGTH_MODULUS, tempBuffer,
                    Configuration.TEMP_OFFSET_MODULUS, Configuration.LENGTH_MODULUS);
    }
    // (x^2 + y^2 - (x-y)^2)/2
   JBigInteger.modular_division_by_2(ram_y, IConsts.OFFSET_START,Configuration. LENGTH_MODULUS, tempBuffer, Configuration.TEMP_OFFSET_MODULUS, Configuration.LENGTH_MODULUS);
   return ram_y;
}