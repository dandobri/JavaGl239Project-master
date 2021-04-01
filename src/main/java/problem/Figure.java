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

}
