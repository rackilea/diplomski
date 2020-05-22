for (double val=4d; val <= 5.1d; val=val+0.1d) {
    double step = val > 0 ? -0.5d : 0.5d;
    System.out.println(val + "->" + Math.round(2*val+step)/2d);
}

4.0->4.0
4.1->4.0
4.2->4.0
4.3->4.0
4.4->4.0
4.5->4.5
4.6->4.5
4.7->4.5
4.8->4.5
4.9->4.5
5.0->5.0
5.1->5.0