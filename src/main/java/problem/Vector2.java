package problem;

public class Vector2 {
    public double x;
    public double y;
    public double k;
    public Vector2(double x,double y){
        this.x=x;
        this.y=y;
    }
    public Vector2(){
        x=1;
        y=0;
    }
    public  Vector2(Vector2 p){
        this.x=p.x;
        this.y=p.y;
    }
    public Vector2 mult(double k){
        Vector2 mult=new Vector2(x * k,y * k);
        return mult;
    }
    public double mult(Vector2 p){
        return p.x * x+ p.y * y;
    }
    public  static double mult(Vector2 p,Vector2 q){
        return p.x * q.x + p.y * q.y;
    }
    public static Vector2 mult(Vector2 p,double k){
        Vector2 mult=new Vector2(p.x * k,p.y * k);
        return mult;
    }
    @Override
    public String toString() {
        String s=String.format("(%.2f,%.2f)",x,y);
        return s;
    }
}
