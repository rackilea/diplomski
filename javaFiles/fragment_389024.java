vector<uchar> buff;
vector<int> params;

params.push_back(cv::IMWRITE_JPEG_QUALITY);
//80 keeps the image size under 64KB ,ON MY CAMERA, so I can send the image in one piece
params.push_back(80);
cv::imencode(".jpg", frame, buff, params);

boost::asio::ip::udp::socket* _socket;
...
_socket->send_to(boost::asio::buffer(buff), some boost::asio::ip::udp::endpoint, 0, some boost::system::error_code);