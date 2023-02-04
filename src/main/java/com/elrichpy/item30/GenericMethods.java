package com.elrichpy.item30;

import java.util.*;
import java.util.function.UnaryOperator;

public class GenericMethods {
    private static final UnaryOperator<Object> IDENTITY_FN = (t) -> t;
    public static void main(String[] args) {
        Set<String> set1 = Set.of("John", "Dave");
        Set<String> set2 = Set.of("Bob");
        Set<String> set3 = union(set1, set2);
        System.out.println(set3);

        Set<A> setWildcard1 = Set.of(new A("Susan"), new A("Beth"));
        Set<B> setWildcard2 = Set.of(new B("Susan"), new B("Beth"));
        Set<A> setWildcard3 = unionWithWildCard(setWildcard1, setWildcard2);
//        Set<A> doesntWork = union(setWildcard1, setWildcard2);
        System.out.println(setWildcard3);

        String maxString = max(List.of("A", "B", "C")).orElse("No max found!");
        Optional<Integer> maxInteger = max(List.of(4, 22, 1));
    }


    public static <E> Set<E> union(Set<E> set1, Set<E> set2) {
        Set<E> set3 = new HashSet<>(set1);
        set3.addAll(set2);
        return set3;
    }

    public static <E> Set<E> unionWithWildCard(Set<? extends E> set1, Set<? extends E> set2) {
        Set<E> set3 = new HashSet<>(set1);
        set3.addAll(set2);
        return set3;
    }
    public static class A {
        public String name;
        A (String name) {this.name = name;}

        @Override
        public String toString() {
            return name;
        }
    }
    public static class B extends A{

        B (String name) {super(name);}

    }
    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }
    // Recursive type bounds
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> collection) {

        if (collection.isEmpty()){
            return Optional.empty();
        }
        return collection.stream().max(Comparable::compareTo);

    }

}
