package cl.andres.generics;

public class GenericMethod {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "Apple");
        Pair<Integer, String> pair2 = new Pair<>(2, "Pear");

        // Call to method explicitly
        boolean sameExplicitly = Util.<Integer, String>compare(pair1, pair2);

        // Call to method inference
        boolean sameInference = Util.compare(pair1, pair2);

        System.out.println(sameExplicitly);
        System.out.println(sameInference);
    }
}
