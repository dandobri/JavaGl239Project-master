package problem;

import javax.media.opengl.GL2;

public class Figure {

  public static void renderPoint(GL2 gl,Vector2 pos,double size){
      gl.glPointSize((float) size);
      gl.glBegin(GL2.GL_POINTS);
      gl.glVertex2d(pos.x,pos.y);
      gl.glEnd();
  }
  public static void renderLine(GL2 gl,Vector2 posA,Vector2 posB,double width){
      gl.glLineWidth((float) width);
      gl.glBegin(GL2.GL_LINES);
      gl.glVertex2d(posA.x,posA.y);
      gl.glVertex2d(posB.x,posB.y);
      gl.glEnd();
  }
  public static void renderTriangle(GL2 gl,Vector2 posA,Vector2 posB,Vector2 posC,boolean filled) {
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
  }
    public static void renderQuad(GL2 gl,Vector2 posA,Vector2 posB,Vector2 posC,Vector2 posD,boolean filled) {
        if(filled) {
            gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2d(posA.x, posA.y);
            gl.glVertex2d(posB.x, posB.y);
            gl.glVertex2d(posC.x, posC.y);
            gl.glVertex2d(posD.x, posD.y);
            gl.glEnd();
        }else {
            gl.glBegin(GL2.GL_LINE_STRIP);
            gl.glVertex2d(posA.x,posA.y);
            gl.glVertex2d(posB.x,posB.y);
            gl.glVertex2d(posC.x,posC.y);
            gl.glVertex2d(posD.x,posD.y);
            gl.glVertex2d(posA.x,posA.y);
            gl.glEnd();
        }
    }
    public static void renderCircle(GL2 gl,Vector2 center,double rad,boolean filled){
double x=0;
double y=0;
      if(!filled){
          gl.glVertex2d(center.x,center.y);
          gl.glBegin(GL2.GL_LINE_STRIP);
          for(int i=0;i<101;i++){
               x=rad*Math.cos(2 * Math.PI* i/100)+center.x;
               y=rad*Math.sin(2 * Math.PI* i/100)+center.y;
              gl.glVertex2d(x,y);
          }
      }
      else {
gl.glPointSize((float)1);
gl.glBegin(GL2.GL_TRIANGLE_FAN);
for(int i=0;i<100;i++){
    x=rad*Math.cos(2 * Math.PI* i/100)+center.x;
    y=rad*Math.sin(2 * Math.PI* i/100)+center.y;
    gl.glVertex2d(x,y);
}
      }
      gl.glEnd();
    }
}
