package aquarium;

import sanctuary.Elephant;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    public String name;
    public int capacity;
    public int size;
    public List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        if (fishInPool.size() < capacity) {
            if (!fish.getName().equals(this.name)){
                fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name){
        for (Fish fish : this.fishInPool){
            if (fish.getName().equals(name)){
                this.fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name){
        for (Fish fish : this.fishInPool){
            if (fish.getName().equals(name)){
                return fish;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sB = new StringBuilder();
        sB.append("Aquarium: "+name + "^ Size: " + size).append(System.lineSeparator());
        for (Fish fish : this.fishInPool) {
            sB.append(String.format("%s", fish))
                    .append(System.lineSeparator());
        }
        return sB.toString().trim();
    }
}
