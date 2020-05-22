class Version {  

static final int INCREMENT_UNIT = 1;

int major, minor, point;  

Version(String version) {
    String parts[] = version.split(".");

    this.major = Integer.parseInt(parts[0]);
    this.minor = Integer.parseInt(parts[1]);
    this.point = Integer.parseInt(parts[2]);
 }

 Version incrementMajor(int unit) {
    this.major += unit; 

    return this;
 }

 Version incrementMinor(int unit) {
    this.minor += unit; 

    return this;
 }

 Version incrementPoint(int unit) {
    this.point += unit;

    return this; 
 }

String toString() {
    return major + "." + minor + "." + point;
}

}