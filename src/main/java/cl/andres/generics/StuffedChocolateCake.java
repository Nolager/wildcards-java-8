package cl.andres.generics;

public class StuffedChocolateCake extends ChocolateCake {

    private long id;

    public StuffedChocolateCake(long id) {
        super(id);
        this.id = id;
    }

    @Override
    public String getName() {
        return this.getClass().getName().concat(" ID: " + this.id);
    }
}
