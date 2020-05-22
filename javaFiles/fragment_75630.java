Scanner reader = new Scanner(System.in);

System.out.println("Enter a start: ");
int s = reader.nextInt();

System.out.println("Enter a end: ");
int e = reader.nextInt();

RangeSet<Integer> rangeSet= TreeRangeSet.create();

            if(rangeSet.isEmpty()){
                System.out.println("1 Empty");
                rangeSet.add(Range.closed(s, e));
            }else {
                System.out.println("1 Not Empty");
                if(!rangeSet.encloses(Range.closed(s, e)) && !rangeSet.intersects(Range.open(s, e))){
                    System.out.println("2 Yes");
                    rangeSet.add(Range.closed(s, e));
                }else{
                    System.out.println("2 No");
                }
            }
            System.out.println("Range: " + rangeSet)