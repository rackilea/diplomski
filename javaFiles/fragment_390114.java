INSERT INTO [ANTICIPI_FATTURE_KOFAX]
       ([ID],[ID_BATCH],[ID_FASCICOLO],[ABI],[CED]
       ,[ORIGINE],[TIPO],[IMPORTO],[PEZZI]
       ,[NUMERO_FATTURA],[PAGINA_FATTURA],[TRASMESSO]
       ,[NUMERO_FATTURA_ELAB],[DATA_CREAZIONE])
   <foreach collection="anticipi" item="item" open="SELECT" separator="UNION ALL SELECT">
      #{item.ID} ,#{item.ID_BATCH},#{item.ID_FASCICOLO}
       ,#{item.ABI},#{item.CED},#{item.ORIGINE}
       ,#{item.TIPO},#{item.IMPORTO},#{item.PEZZI}
       ,#{item.NUMERO_FATTURA},#{item.PAGINA_FATTURA}
       ,#{item.TRASMESSO},#{item.NUMERO_FATTURA_ELAB}
       ,#{item.DATA_CREAZIONE}
   </foreach> 
</insert>