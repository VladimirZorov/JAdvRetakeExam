package easterBasket;

public class Egg {

    public String color;
    public  int srength;
    public String shape;

    public Egg(String color, int srength, String shape) {
        this.color = color;
        this.srength = srength;
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSrength() {
        return srength;
    }

    public void setSrength(int srength) {
        this.srength = srength;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return String.format
                ("%s egg, with %d strength and %s shape.", color, srength,shape);
    }
}
