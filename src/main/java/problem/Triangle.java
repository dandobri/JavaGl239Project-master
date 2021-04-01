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
        this.a = new Vector2(a.x, a.y);
        this.b = new Vector2(b.x, b.y);
        this.c = new Vector2(c.x, c.y);
    }

    public void render(GL2 gl) {
        Figure.renderTriangle(gl, a, b, c, false);
    }

    public boolean regular() {
        double r1 = Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
        double r2 = Math.sqrt((c.x - b.x) * (c.x - b.x) + (c.y - b.y) * (c.y - b.y));
        double r3 = Math.sqrt((a.x - c.x) * (a.x - c.x) + (a.y - c.y) * (a.y - c.y));
        return Math.abs(r1 - r2) < 0.01 && Math.abs(r1 - r3) < 0.01 && Math.abs(r2 - r3) < 0.01;
    }
}
