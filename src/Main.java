import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream <Runners> runnersStream = Stream.of(new Runners("Anna",100),
                new Runners("Tatiana", 102),
                new Runners("Sofia", 99));
        BiConsumer <Runners, Runners> biConsumer = (min, max) -> System.out.println(min.toString() + max.toString());
        Comparator <Runners> runnersComparator = Comparator.comparing(Runners::getName).thenComparing(Runners::getBestRunningTime);
        Comparator<String> comparator2 = Comparator.comparing(String::length);
        findMinMax(runnersStream, runnersComparator, biConsumer);

        findCountEvenNums(List.of(4, 18, 35, 78, 99, 45));
    }
    //Задание 1
    //Напишите метод public static void findMinMax, который будет находить в стриме минимальный и максимальный элементы в соответствии
    // с порядком, заданным Comparator'ом. Данный метод принимает на вход 3 элемента: Stream <? extends T> stream
    //Comparator <? super T> order
    //BiConsumer <? super T, ? super T> minMaxConsumer
    //Найденные минимальный и максимальный элементы передавайте в minMaxConsumer следующим образом: minMaxConsumer.accept(min, max);
    //Если стрим не содержит элементов, то вызывайте: minMaxConsumer.accept(null, null);*/
    public static <T> void findMinMax (
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T>minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get (0), list.get(list.size() - 1));
        }
    }
    //Задание 2
    //Реализуйте метод, который принимает на вход список целых чисел, определяет в списке количество четных чисел и
    // выводит их в консоль. Решите задание именно с применением Stream API.
    public static void findCountEvenNums(List<Integer> list){
        Stream<Integer> stream = list.stream();
        Predicate<Integer> predicate = (n) -> (n % 2) == 0;
        Stream<Integer> resStream = stream.filter(predicate);
        System.out.println("Колличество чётных чисел: " + resStream.count());
    }
}