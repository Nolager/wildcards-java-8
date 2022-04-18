package cl.andres.generics;

public abstract class Cake {

    private long id;

    public Cake(long id) {
        this.id = id;
    }

    public String getName() {
        return this.getClass().getName().concat(" ID: " + this.id);
    }
}
