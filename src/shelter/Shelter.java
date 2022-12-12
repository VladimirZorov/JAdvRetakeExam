package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {

    public int capacity;
    public List<Animal> animals;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.animals = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void add(Animal animal) {
        if (this.animals.size() < this.capacity){
            this.animals.add(animal);
        }
    }
    public  boolean remove(String name) {
        for (int i = 0; i < this.animals.size(); i++) {
            if (this.animals.get(i).getName().equals(name)){
                this.animals.remove(i);
                return true;
            }
        }
        return false;
    }

}
