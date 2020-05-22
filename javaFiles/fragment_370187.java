RUN wget https://www.rforge.net/src/contrib/Rserve_1.8-5.tar.gz
RUN tar -xf Rserve_1.8-5.tar.gz
RUN rm Rserve_1.8-5.tar.gz
RUN sed -i '1763s/.*/\t\tint port = 53000;/' /Rserve/src/Rserv.c
RUN sed -i '1781s/.*//' /Rserve/src/Rserv.c
RUN sed -i '1793s/.*/\t\tif (port>53100) {/' /Rserve/src/Rserv.c
RUN tar -czvf Rserve_1.8-5.tar.gz /Rserve
RUN R CMD INSTALL Rserve_1.8-5.tar.gz