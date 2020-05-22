public function test()
{
    $test = $this->serviceManager->get('test\Model\test');
    //print_r($test);exit;
    $message = array(
        'to'        =>  'abhi',
        'message'   =>  'this is a test',
    );
    $test->sendtoJavaWorker($message);
}