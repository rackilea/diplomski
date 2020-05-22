class Client {

    private $addressServer;
    private $portServer;
    private $address;
    private $port;
    private $command;

    public function __construct($port, $address, $addressServer, $portServer, $command)
    {
        set_time_limit(0);
        $this->addressServer = $addressServer;
        $this->address = $address;
        $this->portServer = $portServer;
        $this->port = $port;
        $this->command = $command;
        $this->init();
    }

    private function init() {

        //Send request to the Java server
        $request = new Request(
            $this->addressServer, $this->portServer, $this->command
        );

        //create socket
        if (! $socket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP)) {
            $this->showError('socket create');
        }
        echo "Server Created\n";

        //Bind socket
        if (!socket_bind($socket, $this->address, $this->port)) {
            $this->showError('socket bind');
        }
        echo "Server bind to $this->address and $this->port \n";

        if (!socket_listen($socket)) {
            $this->showError('socket listen');
        }
        echo "Server Listening \n";

        do {
            $client = socket_accept($socket);
            echo "connection established\n";

            if(!$clientMessage = socket_read($client, 10000, PHP_NORMAL_READ)){
                $this->showError('socket read');
            }

            echo "Command Received\n";
            echo $clientMessage;

        } while(true);
    }

    private function showError($message){
        echo ("Error: ".$message);
        exit(666);
    }
}