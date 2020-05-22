resource "aws_instance" "api" {
  ami           = "${data.aws_ami.ubuntu.id}"
  instance_type = "t2.micro"
}

resource "aws_instance" "web" {
  ami           = "${data.aws_ami.ubuntu.id}"
  instance_type = "t2.micro"
}

resource "aws_instance" "app" {
  ami           = "${data.aws_ami.ubuntu.id}"
  instance_type = "t2.micro"
}