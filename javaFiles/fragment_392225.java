{
    if (sender instanceof EntityPlayer) {
        final EntityPlayer player = (EntityPlayer) sender;
        final World par2World = player.worldObj;

        final float power;

    // The "default" method:
        // power = 5; // Write the default value here!
        if (var2.length > 0) try {
            power = Float.parseFloat(var2[0]); // Parse the first argument.
        } catch(NumberFormatException ex) {}

    // The "validation" method:
        if (var2.length == 0) {
            sender.sendMessage("You forgot to specify the fireball power.");
            return;
        }
        if ( !var2[0].matches("\\d{2}")) { // Asserts this argument is two digits
            sender.sendMessage("Incorrect.");
            return;
        }
        power = Float.parseFloat(var2[0]);

        if ( !par2World.isRemote)
            par2World.spawnEntityInWorld(new PlayerFireBall(par2World, power));
    }
}