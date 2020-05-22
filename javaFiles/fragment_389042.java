while (true)
{
    option = ...;
    switch (option)
    {
    case 0:
        submenu();
        break;
    // ...
    }
}

// later
public void submenu()
{
    while (true)
    {
        option = ...;
        switch (option)
        {
        case 0:
            return;
            break;
        // ...
        }
    }
 }