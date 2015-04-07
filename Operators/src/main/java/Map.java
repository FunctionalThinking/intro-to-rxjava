import rx.Observable;
import rx.functions.Func1;

public class Map {
    public static void map() {
        Observable.just(1, 2, 3, 4, 5)
            .map(new Func1<Integer, Integer>() {
                @Override
                public Integer call(Integer i) {
                    return i * 2;
                }
            })
            .subscribe(
                    item -> System.out.println("Map item: " + item),
                    throwable -> {},
                    () -> System.out.println("Sequence complete.")
            );

        Observable.just(1, 2, 3, 4, 5)
            .map(item -> item * 2)
            .subscribe(
                item -> System.out.println("Map item: " + item),
                throwable -> {},
                () -> System.out.println("Sequence complete.")
            );
    }
}
