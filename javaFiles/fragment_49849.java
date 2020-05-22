public  void path_Extraction(Node root)
{

         int i=0;

         while(root.childs.size()!=0)
        {   
            Node childs=root.childs.get(0);
            while(childs.count!=0)
            {   ArrayList<Node> path=new ArrayList<Node>();
                ArrayList<Node> remove=new ArrayList<Node>();
                i++;
                extract(childs,path,remove);
                paths.put(i,path);
                Removing_node.remove.put(i, remove);
            }

            }
        }


 public void extract(Node childs,ArrayList<Node> path,ArrayList<Node> remove)
{
    if(childs.count>1)
    {
        if(childs.childs.size()>0)
        {
            extract(childs.childs.get(0),path,remove);
            childs.count--;
            if(childs.count==0)
            {

                childs.parent.childs.remove(childs);
                childs.parent=null;
                path.add(childs);       
                remove.add(childs);
            }
            else
            {

                path.add(childs);
            }

        }
    }
    else
    {
        if(childs.childs.size()>0)
        {
            extract(childs.childs.get(0),path,remove);
            childs.count--;

            childs.parent.childs.remove(childs);
            childs.parent=null;
            path.add(childs);
            remove.add(childs);
        }
        else
        {
            (childs.count)--;

            childs.parent.childs.remove(childs);
            childs.parent=null;
            path.add(childs);
            remove.add(childs);

        }
        }
    }