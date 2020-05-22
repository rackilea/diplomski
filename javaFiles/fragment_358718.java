521:   /**
 522:    * Measures the square of the shortest distance from the reference point
 523:    * to a point on the infinite line extended from the segment. If the point
 524:    * is on the segment, the result will be 0. If the segment is length 0,
 525:    * the distance is to the common endpoint.
 526:    *
 527:    * @param x1 the first x coordinate of the segment
 528:    * @param y1 the first y coordinate of the segment
 529:    * @param x2 the second x coordinate of the segment
 530:    * @param y2 the second y coordinate of the segment
 531:    * @param px the x coordinate of the point
 532:    * @param py the y coordinate of the point
 533:    * @return the square of the distance from the point to the extended line
 534:    * @see #ptLineDist(double, double, double, double, double, double)
 535:    * @see #ptSegDistSq(double, double, double, double, double, double)
 536:    */
 537:   public static double ptLineDistSq(double x1, double y1, double x2, double y2,
 538:                                     double px, double py)
 539:   {
 540:     double pd2 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
 541: 
 542:     double x, y;
 543:     if (pd2 == 0)
 544:       {
 545:         // Points are coincident.
 546:         x = x1;
 547:         y = y2;
 548:       }
 549:     else
 550:       {
 551:         double u = ((px - x1) * (x2 - x1) + (py - y1) * (y2 - y1)) / pd2;
 552:         x = x1 + u * (x2 - x1);
 553:         y = y1 + u * (y2 - y1);
 554:       }
 555: 
 556:     return (x - px) * (x - px) + (y - py) * (y - py);
 557:   }
 558: 
 559:   /**
 560:    * Measures the shortest distance from the reference point to a point on
 561:    * the infinite line extended from the segment. If the point is on the
 562:    * segment, the result will be 0. If the segment is length 0, the distance
 563:    * is to the common endpoint.
 564:    *
 565:    * @param x1 the first x coordinate of the segment
 566:    * @param y1 the first y coordinate of the segment
 567:    * @param x2 the second x coordinate of the segment
 568:    * @param y2 the second y coordinate of the segment
 569:    * @param px the x coordinate of the point
 570:    * @param py the y coordinate of the point
 571:    * @return the distance from the point to the extended line
 572:    * @see #ptLineDistSq(double, double, double, double, double, double)
 573:    * @see #ptSegDist(double, double, double, double, double, double)
 574:    */
 575:   public static double ptLineDist(double x1, double y1,
 576:                                    double x2, double y2,
 577:                                    double px, double py)
 578:   {
 579:     return Math.sqrt(ptLineDistSq(x1, y1, x2, y2, px, py));
 580:   }
 581: