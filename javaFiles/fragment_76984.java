public void setBlockBoundsBasedOnState(final IBlockAccess worldIn, final BlockPos pos) {
            this.setBlockBounds(0.25f, 0.125f, 0.25f, 0.75f, 0.875f, 0.75f);
        }

public void addCollisionBoxesToList(final World worldIn, final BlockPos pos, final IBlockState state, final AxisAlignedBB mask, final List list, final Entity collidingEntity) {
        this.setBlockBoundsBasedOnState((IBlockAccess)worldIn, pos);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    }