void MyMethod(Particle3D b)
{
    LeavesBehaviour(b);
    BranchingBehaviour(branchingPercent, b, depth + 1);

    // weight behaviour
    if (applyWeightOnBranches)
        b.Direction = new Vector3D(initialDirection.X, initialDirection.Y * LineairScaleTo((double)b.Life / (double)branch.MaxLife, -1f, 1f), initialDirection.Z);// +(2 * (((double)b.Life / (double)maxLife)) - 1);
};