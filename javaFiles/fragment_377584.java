function out = q47223578()

javaaddpath('G:\core-3.3.1.jar');
javaaddpath('G:\javase-3.3.1.jar');
% Verify using: javaclasspath('-dynamic');

qr = imread('https://i.stack.imgur.com/mA4eP.png');

out = decode_qr(qr);