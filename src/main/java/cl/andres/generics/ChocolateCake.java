package cl.andres.generics;

public class ChocolateCake extends Cake {

    private long id;

    public ChocolateCake(long id) {
        super(id);
        this.id = id;
    }

    @Override
    public String getName() {
        return this.getClass().getName().concat(" ID: " + this.id);
    }
}
