package cl.andres.wildcards;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        /**
         * Upper Bounded Wildcards
         */
        // Upper Bounded Integer List
        List<Integer> upperBoundedList1 = Arrays.asList(4, 5, 6, 7);

        // printing the sum of elements in list
        System.out.println("Total sum is: " + upperBoundedWildcard(upperBoundedList1));

        // Double list
        List<Double> upperBoundedList2 = Arrays.asList(4.1, 5.1, 6.1);

        // printing the sum of elements in list
        System.out.println("Total sum is: " + upperBoundedWildcard(upperBoundedList2));

        // Throws error because String doesn't extend from Number
        List<String> upperBoundedList3 = Arrays.asList("8", "9", "10");
//        System.out.print("Total sum is: " + upperBoundedWildcardSum(upperBoundedList3));

        /**
         * Lower Bounded Wildcards
         */
        // Lower Bounded Integer List
        List<Integer> lowerBoundedList1 = Arrays.asList(4, 5, 6, 7);

        // Integer list object is being passed
        lowerBoundedWildcard(lowerBoundedList1);

        // Number list
        List<Number> lowerBoundedList2 = Arrays.asList(4, 5, 6, 7);

        // Integer list object is being passed
        lowerBoundedWildcard(lowerBoundedList2);

        // Throws error because this method receives an Integer or its superclass. Double is not the superclass of Integer.
        List<Double> lowerBoundedList3 = Arrays.asList(8.0, 9.0, 10.0);
//        lowerBoundedWildcardPrint(lowerBoundedList3);

        /**
         * Note: Use extend wildcard when you want to get values out of a structure and super wildcard when you put
         * values in a structure. Don’t use wildcard when you get and put values in a structure. You can specify an
         * upper bound for a wildcard, or you can specify a lower bound, but you cannot specify both.
         */

        /**
         * Unbounded Wildcard
         */
        // Integer List
        List<Integer> unboundedList1 = Arrays.asList(1, 2, 3);

        // Double list
        List<Double> unboundedList2 = Arrays.asList(1.1, 2.2, 3.3);

        // BigDecimal list
        List<BigDecimal> unboundedList3 = Arrays.asList(BigDecimal.valueOf(1.1),
                BigDecimal.valueOf(2.2),
                BigDecimal.valueOf(3.3));

        // String list
        List<String> unboundedList4 = Arrays.asList("1.1", "2.2", "3.3");

        unboundedWildcard(unboundedList1);
        unboundedWildcard(unboundedList2);
        unboundedWildcard(unboundedList3);
        unboundedWildcard(unboundedList4);
    }

    /**
     * These wildcards can be used when you want to relax the restrictions on a variable. For example, say you want to
     * write a method that works on List<Integer>, List<Double>, and List<Number>, you can do this using an upper
     * bounded wildcard.
     */
    public static double upperBoundedWildcard(List<? extends Number> list) {

        double sum = 0.0;

        for (Number i : list) {
            sum += i.doubleValue();
        }

        return sum;
    }

    /**
     * Here arguments can be Integer or superclass of Integer(which is Number). This method will only take Integer or
     * its superclass objects. However, if we pass a list of types Double then we will get a compilation error. It is
     * because only the Integer field or its superclass can be passed. Double is not the superclass of Integer.
     */
    public static void lowerBoundedWildcard(List<? super Integer> list) {
        System.out.println(list);
    }

    /**
     * This wildcard type is specified using the wildcard character (?), for example, List. This is called a list of
     * unknown types. These are useful in the following cases:
     *
     * - When writing a method that can be employed using functionality provided in Object class.
     * - When the code is using methods in the generic class that doesn't depend on the type parameter.
     */
    public static void unboundedWildcard(List<?> list) {
        System.out.println(list);
    }
}
