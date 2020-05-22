syntax = "proto3";
package MyPackage;
option optimize_for = SPEED;

message Product {
   repeated ASale sale = 1; 
}