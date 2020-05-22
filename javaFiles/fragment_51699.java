Collections.sort(ll);

                ListIterator liter = ll.listIterator();
                Collections.sort(ll);
                liter = ll.listIterator();

                DefaultListModel model = (DefaultListModel) listbooks.getModel();
                model.clear();
                for (Object element : ll)
                    model.addElement(element);
                //while (liter.hasNext())
                //  System.out.println(liter.next());