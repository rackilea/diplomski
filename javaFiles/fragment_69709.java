Find_polygon(vertex u,int iter,vertex[] path)  {

         if(!visited[u]) {
               visited[u] = true;
               path[iter] = u;
               if(iter==1) {
                  source = u;
                  for all edge(u,v)
                    Find_polygon(v,iter+1,path);

               }
               else {

                    for all edge(u,v) {
                      if(slope(u,v)!=slope(path[iter-1],u)) {
                             Find_polygon(v,iter+1,path);
                      }
                    }
               }      
            }

         else  {       //loop 

                      index = findIndex(u,path); // can use array for O(1)
                      polygons.add(path[index to iteration])


         }

       }

  polygons = [];
  for all vertices v in graph :
          Find_polygon(v);