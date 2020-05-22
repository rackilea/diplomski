Response responseA = ;
Response responseB = ;

OkHttpClient okHttpClient = mock(OkHttpClient.class);
Call call = mock(Call.class);

when(call.execute()).thenReturn(responseA).thenReturn(responseB);
when(okHttpClient.newCall(any(Request.class))).thenReturn(call);