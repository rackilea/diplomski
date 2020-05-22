StringBuilder sb = new StringBuilder();
for (int i=0;i<=30;i++){
                nRespuesta  = i+1;
                nRespuestaString = Integer.toString(nRespuesta);
                Respuesta = Verbal.getRespuestas(i);
                //Note the change on the line below
                sb.append(nRespuestaString).append("-").append(Respuesta).append(",");
            }
serializer.startTag(null, "RESPUESTAS");
            serializer.text(sb.toString());
            serializer.endTag(null, "RESPUESTAS");