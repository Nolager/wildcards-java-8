package cl.andres.generics;

public class VanillaCake extends Cake {

    private long id;

    public VanillaCake(long id) {
        super(id);
        this.id = id;
    }

    @Override
    public String getName() {
        return this.getClass().getName().concat(" ID: " + this.id);
    }
}
