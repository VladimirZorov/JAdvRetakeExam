package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {

    public String material;
    public  int capacity;
    public List<Egg> data = new ArrayList<>();

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg (Egg egg) {
        if (this.data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg (String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)){
                this.data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg () {
        return this.data.stream().max(Comparator.comparing(Egg::getSrength)).get();
    }

    public Egg getEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)){
                return  egg;
            }
        }
        return  null;
    }
    public int getCount (){
        return data.size();
    }

    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:%n",material));

        data.forEach(egg -> sb.append(egg.toString()).append(String.format("%n")));

        return sb.toString().trim();
    }
}
