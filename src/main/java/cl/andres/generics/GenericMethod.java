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

        Object[] numbersArray = new Object[2];
        numbersArray[0] = 1;
        numbersArray[1] = 2;
        Arrays.stream(swapElements(numbersArray, 0, 1)).forEach(System.out::println);

        List<Number> integersList = Arrays.asList(3, 4);
        swapElements(integersList, 0, 1).forEach(System.out::println);

        // FIXME: 19-04-22 This throws cast error
//        Integer[] integersArray = new Integer[2];
//        integersArray[0] = 5;
//        integersArray[1] = 6;
//        Number[] swapedNumbers = swapElements(integersArray, 0, 1);
//        Arrays.stream(swapedNumbers).forEach(System.out::println);

        List<Number> numbersList = Arrays.asList(Integer.valueOf("7"), Integer.valueOf("8"));
        swapElements(numbersList, 0, 1).forEach(System.out::println);
    }

    public static <T> List<T> union(List<? extends T> firstList, List<? extends T> secondList) {

        List<T> unionList = new ArrayList<>();
        unionList.addAll(firstList);
        unionList.addAll(secondList);

        return unionList;
    }

    public static <T> T[] swapElements(Object[] array, int firstIndex, int secondIndex) {
        Object[] copyOfArray = new Object[array.length];
        System.arraycopy(array, 0, copyOfArray, 0, array.length);

        copyOfArray[firstIndex] = array[secondIndex];
        copyOfArray[secondIndex] = array[firstIndex];

        return (T[]) copyOfArray;
    }

    public static <T> List<T> swapElements(List<? extends T> list, int firstIndex, int secondIndex) {

        List<T> copyOfList = new ArrayList<>();
        copyOfList.add(list.get(secondIndex));
        copyOfList.add(list.get(firstIndex));

        return copyOfList;
    }
}
