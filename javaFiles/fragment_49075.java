public class Quaternion {
    public double w, x, y, z;
    public Quaternion(double angleRadian, double x, double y, double z){
        double dAngle=angleRadian/2; //might as well divide by 2 here
        this.w=Math.cos(dAngle);
        this.x=x * Math.sin(dAngle);
        this.y=y * Math.sin(dAngle);
        this.z=z * Math.sin(dAngle);
    }
    public Quaternion(){
        x=y=z=0; w=1;
    }
    public void norm(){
        double magnitude = Math.sqrt(w*w + x*x + y*y + z*z);
        w = w / magnitude;
        x = x /  magnitude;
        y = y / magnitude;
        z = z / magnitude;
    }
    public Quaternion conj(){
        Quaternion ans = new Quaternion();
        ans.set(this);
        ans.conjLocal();
        return ans;
    }
    public void conjLocal(){
        x=-x;
        y=-y;
        z=-z;
    }
    public void set(Quaternion q){
        w=q.w;
        x=q.x;
        y=q.y;
        z=q.z;
    }
    public void set(double w, double x, double y, double z){
        this.w=w;
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public Quaternion mult(Quaternion q){
        Quaternion ans = new Quaternion();
        ans.w = (this.w*q.w - this.x*q.x - this.y*q.y - this.z*q.z);
        ans.x = (this.w*q.x + this.x*q.w + this.y*q.z - this.z*q.y);
        ans.y = (this.w*q.y - this.x*q.z + this.y*q.w + this.z*q.x);
        ans.z = (this.w*q.z + this.x*q.y - this.y*q.x + this.z*q.w);
        return ans;
    }
    public void multLocal(Quaternion q){
        Quaternion temp=this.mult(q);
        this.set(temp);
    }
    public String toString(){ return "<"+w+", "+x+", "+y+", "+z+">"; }
}