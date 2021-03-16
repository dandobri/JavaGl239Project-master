package problem;

import javax.media.opengl.GL2;
import java.util.Random;

public class Triangle {
    public Vector2 a;
    public Vector2 b;
    public Vector2 c;

    public Triangle(Vector2 a, Vector2 b, Vector2 c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = new Vector2(a.x,a.y);
        this.b = new Vector2(b.x,b.y);
        this.c = new Vector2(c.x,c.y);
    }

    public void render(GL2 gl) {
        Figure.renderTriangle(gl, a, b, c, false);
    }

    public boolean regular() {

    }
}
