import rx.Observable;

public class Reduce {

    public static void reduce() {
        Observable.just(1, 2, 3, 4, 5)
                .map(item -> item * 2)
                .reduce((x, y) -> x + y)
                .subscribe(
                    item -> System.out.println("Reduce item: " + item),
                    throwable -> {},
                    () -> System.out.println("Sequence complete.")
                );
    }
}
