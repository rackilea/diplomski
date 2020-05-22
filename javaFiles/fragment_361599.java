public static void main (String[] args)
{
    /* Values Array */
    double x[] = {2, 4, 1, 1};
    double y[] = {1, 3, 1, 9};

    /* Clusters Array */
    Double[] cluster1 = {1.0};
    Double[] cluster2 = {2.0};
    Double[] cluster3 = {3.0, 4.0};

    /* Print Cluster 1 Values */
    System.out.print("Cluster 1:");
    for(int i = 0; i < cluster1.length; i++) {
        System.out.print(" (" + x[cluster1[i].intValue() - 1] + "," + y[cluster1[i].intValue() - 1] + ")");
    }

    /* Print Cluster 2 Values */
    System.out.print("\nCluster 2:");
    for(int i = 0; i < cluster2.length; i++) {
        System.out.print(" (" + x[cluster2[i].intValue() - 1] + "," + y[cluster2[i].intValue() - 1] + ")");
    }

    /* Print Cluster 3 Values */
    System.out.print("\nCluster 3:");
    for(int i = 0; i < cluster3.length; i++) {
        System.out.print(" (" + x[cluster3[i].intValue() - 1] + "," + y[cluster3[i].intValue() - 1] + ")");
    }
}