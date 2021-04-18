/**
O exemplo a seguir, escrito em Java, implementa uma classe gráfica, 
na qual, pode ser uma elipse ou um círculo ou uma composição de diversas outras formas 
geometrias, que, todas podem ser representadas no gráfico.

Ele pode ser estendido para implementar diversos outras formas
 (círculo, quadrado, etc.) no gráfico. 
**/

import java.util.ArrayList;
import java.util.List;

/** "Component" **/
interface Graphic {

    //Printa o grafico.
    public void print();
    public double area();
    public double perimetro();
}

/** "Composite" **/
class CompositeGraphic implements Graphic {

    //Coleção de Graficos  filhos
    private List<Graphic> childGraphics = new ArrayList<>();

    //Printa o grafico
    public void print() {
        for (Graphic graphic : childGraphics) {
            graphic.print();
        }
    }
    public double area() {
        double area_todo = 0;
        for (Graphic graphic : childGraphics) {
            area_todo += graphic.area();
        }
        return (area_todo);
    }
    public double perimetro() {
        double perimetro_todo = 0;
        for (Graphic graphic : childGraphics) {
            perimetro_todo += graphic.perimetro();
        }
        return (perimetro_todo);
    }

    //Adiciona o grafico a composição.
    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }
    //Remove a forma geometrica da composição.
    public void remove(Graphic graphic) {
        childGraphics.remove(graphic);
    }

}

/** "Leaf" **/
class Ellipse implements Graphic {

    private double radius;
    private double radius1;

    Ellipse(double radius, double radius1) {
        this.radius = radius;
        this.radius1 = radius1;
    }

    //Printa o grafico.
    public void print() {
        System.out.println("Ellipse");
    }
    public double area() {
        return (3.1415 * this.radius * this.radius1);
    }
    public double perimetro() {
        return (2 * 3.1415 * this.radius);
    }
}

/** "Leaf" **/
class Circle implements Graphic {

    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    //Printa o grafico.
    public void print() {
        System.out.println(Circle.class.getName());
    }
    public double area() {
        return (3.1415 * Math.pow(this.radius, 2));
    }
    public double perimetro() {
        return (2 * 3.1415 * this.radius);
    }
}

/** "Leaf" **/
class Square implements Graphic {

    private double side;

    Square(double side) {
        this.side = side;
    }

    //Printa o grafico.
    public void print() {
        System.out.println(Square.class.getName());
    }
    public double area() {
        return (this.side * this.side);
    }
    public double perimetro() {
        return (this.side * 4);
    }
}

/** "Leaf" **/
class Triangle implements Graphic {

    private double side;

    Triangle(double side) {
        this.side = side;
    }

    //Printa o grafico.
    public void print() {
        System.out.println(Triangle.class.getName());
    }
    public double area() {
        double h = Math.sqrt(Math.pow(this.side, 2) + Math.pow(this.side / 2, 2));
        return (h * this.side) / 2;
    }
    public double perimetro() {
        return (this.side * 3);
    }
}

/** Client **/
public class ClienteComposite {

    public static void main(String[] args) {
        //Inicializa quatro elipses
        Ellipse ellipse1 = new Ellipse(1, 3);
        Ellipse ellipse2 = new Ellipse(3, 2);
        Ellipse ellipse3 = new Ellipse(1, 6);
        Ellipse ellipse4 = new Ellipse(5, 6);

        //Inicializa dois triângulos
        Triangle triangle1 = new Triangle(3);
        Triangle triangle2 = new Triangle(8);

        //Inicializa dois quadrados
        Square square1 = new Square(2);
        Square square2 = new Square(3);

        //Inicializa tres componentes do grafico.
        CompositeGraphic graphic = new CompositeGraphic();
        CompositeGraphic graphic1 = new CompositeGraphic();
        CompositeGraphic graphic2 = new CompositeGraphic();

        //Faz o grafico
        graphic1.add(ellipse1);
        graphic1.add(ellipse2);
        graphic1.add(ellipse3);
        graphic1.add(triangle1);
        graphic1.add(triangle2);

        System.out.println("Graphic1 Area: " + graphic1.area());
        System.out.println("Graphic1 Perimetro: " + graphic1.perimetro());

        graphic2.add(ellipse4);
        graphic2.add(square1);

        System.out.println("Graphic2 Area: " + graphic2.area());
        System.out.println("Graphic2 Perimetro: " + graphic2.perimetro());

        graphic.add(graphic1);
        graphic.add(graphic2);
        graphic.add(new Circle(3));
        graphic.add(square2);

       // Printa quatro vezes a String Ellipse, duas vezes a String Triangle, duaz vezes a String Square e uma vez a String Circle  ( Ele printa o grafico completo).
        graphic.print();

        System.out.println("Graphic Area: " + graphic.area());
        System.out.println("Graphic Perimetro: " + graphic.perimetro());
    }
}
