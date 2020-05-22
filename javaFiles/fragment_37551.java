require 'aws-sdk-core'
Aws.config = {
  :access_key_id => "my_access_key",
  :secret_access_key => "my_secret_key",
  :region => 'us-west-2'
}

ec2 = Aws::EC2.new

ec2.run_instances(
    min_count: 1,
    max_count: 1,
    image_id: 'ami-8635a9b6',
    instance_type: 't1.micro',
    placement: {
      availability_zone: 'us-west-2a'
    },
    network_interfaces: [
      {
        subnet_id: 'subnet-e881bd63',
        groups: ['sg-fd53bf5e'],
        device_index: 0,
        associate_public_ip_address: true
      }
    ],
    key_name: 'my-key'
).each do |resp|
  resp.instances.each do |x|
    puts x.instance_id
  end
end