String snapState = snap.getState();
System.out.println("snapState is " + snapState);

System.out.print("Waiting for snapshot to be created");
// Wait for the snapshot to be created
while (snapState.equals("pending"))
{
    Thread.sleep(500);
    System.out.print(".");
    DescribeSnapshotsResult describeSnapRes 
        = ec2.describeSnapshots(new DescribeSnapshotsRequest().withSnapshotIds(snap.getSnapshotId()));
snapState = describeSnapRes.getSnapshots().get(0).getState();
 }
 System.out.println("\nDone.");