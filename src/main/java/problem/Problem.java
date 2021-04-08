package problem;

import javax.media.opengl.GL2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "Задано множество точек в пространстве\n" +
            "Требуется проверить,является ли это множество дважды треугольным";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-1 Добриса Даниила";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;
    private ArrayList<Triangle> triangles;


    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
        triangles = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x координата X точки
     * @param y координата Y точки
     */
    public void addPoint(double x, double y) {
        Point point = new Point(x, y);
        points.add(point);
    }

    /**
     * Решить задачу
     */
    public void solve() {
        triangles.clear();
        boolean flg = true;
        int a = 0;
        // перебираем пары точек
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            for (int j = 0; j < points.size(); j++) {
                Point p2 = points.get(j);
                for (int k = 0; k < points.size(); k++) {
                    if (i == j || j == k || k == i)
                        continue;
                    Point p3 = points.get(k);
                    Triangle t = new Triangle(p, p2, p3);
                    if (t.regular()) {
                        triangles.add(t);
                        a++;
                    }
                }
            }
            if (a / 2 < 2) {
                flg = false;
            }
            System.out.println(a / 2);
            a = 0;
        }
        System.out.println(flg);
    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        points.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                sc.nextLine();
                Point point = new Point(x, y);
                points.add(point);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            for (Point point : points) {
                out.printf("%.2f %.2f\n", point.x, point.y);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
            Point p = Point.getRandomPoint();
            points.add(p);
        }
    }

    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
        triangles.clear();
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
        for (Point point : points) {
            point.render(gl);
        }
        for (Triangle triangle : triangles) {
            triangle.render(gl);
        }
    }

}

