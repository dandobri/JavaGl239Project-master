package problem;
import javax.media.opengl.GL2;
import java.util.Random;

public class Triangles {
    public double a;
    public double b;
    public double c;
    public void Triangle(double a,double b,double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void render(GL2 gl,Vector2 posA,Vector2 posB,Vector2 posC,boolean filled) {
        if(filled){
            gl.glBegin(GL2.GL_TRIANGLES);
            gl.glVertex2d(posA.x,posA.y);
            gl.glVertex2d(posB.x,posB.y);
            gl.glVertex2d(posC.x,posC.y);
            gl.glEnd();}
        else {
            gl.glBegin(GL2.GL_LINE_STRIP);
            gl.glVertex2d(posA.x,posA.y);
            gl.glVertex2d(posB.x,posB.y);
            gl.glVertex2d(posC.x,posC.y);
            gl.glVertex2d(posA.x,posA.y);
            gl.glEnd();
        }
    public static Triangle getRandomTriangle() {
    Random r = new Random();
    double nx1 = r.nextDouble()*2-1;
    double ny1 = r.nextDouble()*2-1
        double nx2  = r.nextDouble()*2-1;
        double nx2  = r.nextDouble()*2-1;
        double nx3  = r.nextDouble()*2-1;
        double nx3  = r.nextDouble()*2-1;
    int nSetVal = r.nextInt(2);
    return new Triangle(nx, ny, nSetVal);
}

}
