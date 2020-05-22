<?php
class File_Streamer
{
    private $_fileName;
    private $_contentLength;
    private $_destination;
    public function __construct()
    {
        if (!isset($_SERVER['HTTP_X_FILE_NAME'])
                || !isset($_SERVER['CONTENT_LENGTH'])) {
                throw new Exception("Invalid Headers!");
        }

        $this->_fileName = $_SERVER['HTTP_X_FILE_NAME'];
        $this->_contentLength = $_SERVER['CONTENT_LENGTH'];
    }
    public function isValid()
    {
        if (($this->_contentLength > 0)) {
            return true;
        }
        return false;
    }
    public function setDestination($destination)
    {
        $this->_destination = $destination;
    }
    public function receive()
    {
        try {
        if (!$this->isValid()) {
            throw new Exception('No file uploaded!');
        }
        $fileReader = fopen('php://input', "r");
        $fileWriter = fopen($this->_destination . $this->_fileName, "w+");
        while(true) {
            $buffer = fgets($fileReader, 4096);
            if (strlen($buffer) == 0) {
                fclose($fileReader);
                fclose($fileWriter);
                return true;
            }
            fwrite($fileWriter, $buffer);
        }
        return false;
        }
        catch(Exception $ex) {
            echo "error: " . $ex->getMessage();
        }
    }
}