use Thrift\Transport\TMemoryBuffer;
use Thrift\Protocol\TBinaryProtocol;

function serialize($thrift) {
  $transport = new TMemoryBuffer();
  $protocol = new TBinaryProtocol($transport);
  $thrift->write($protocol);
  $protocol->getTransport()->flush();

  return $transport->getBuffer();
}