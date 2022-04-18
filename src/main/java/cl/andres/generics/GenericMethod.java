package cl.andres.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        List<ChocolateCake> firstList = Arrays.asList(new ChocolateCake(1), new ChocolateCake(3));
        List<ChocolateCake> secondList = Arrays.asList(new ChocolateCake(2), new ChocolateCake(20));

        List<ChocolateCake> thirdList = Arrays.asList(new ChocolateCake(1), new ChocolateCake(3));
        List<StuffedChocolateCake> fourthList = Arrays.asList(new StuffedChocolateCake(2), new StuffedChocolateCake(20));

        List<StuffedChocolateCake> fifthList = Arrays.asList(new StuffedChocolateCake(1), new StuffedChocolateCake(3));
        List<ChocolateCake> sixthList = Arrays.asList(new ChocolateCake(2), new ChocolateCake(20));

        List<StuffedChocolateCake> seventhList = Arrays.asList(new StuffedChocolateCake(1), new StuffedChocolateCake(3));
        List<ChocolateCake> eighthList = Arrays.asList(new ChocolateCake(2), new ChocolateCake(20));
        List<VanillaCake> ninethList = Arrays.asList(new VanillaCake(11), new VanillaCake(22));

        List<StuffedChocolateCake> tenthList = Arrays.asList(new StuffedChocolateCake(1), new StuffedChocolateCake(3));
        List<ChocolateCake> eleventhList = Arrays.asList(new ChocolateCake(2), new ChocolateCake(20));
        List<VanillaCake> twelvethList = Arrays.asList(new VanillaCake(11), new VanillaCake(22));
        List<ChocolateCake> chocolateUnion = union(tenthList, eleventhList);
        List<Cake> fullUnion = union(chocolateUnion, twelvethList);

        union(firstList, secondList);
        union(thirdList, fourthList);
        union(fifthList, sixthList);
        union(union(seventhList, eighthList), ninethList);

        fullUnion.forEach(cake -> System.out.println(cake.getName()));
    }

    public static <T> List<T> union(List<? extends T> firstList, List<? extends T> secondList) {

        List<T> unionList = new ArrayList<>();
        unionList.addAll(firstList);
        unionList.addAll(secondList);

        return unionList;
    }
}
