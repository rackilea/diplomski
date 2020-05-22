String[] parts = command.split(' ');
switch(parts[0])
{
    case "MOVE":
        float position = Float.parseFloat(parts[1])
        float speed = Float.parseFloat(parts[2])
        move(position, speed);
        break;

    case ... :

    ...

    default:
        System.out.println("Unknown command");
        break;

}