import rx.Observable;

public class FlatMap {
    public static void flatMap() {
        Observable.just(1, 2, 3, 4, 5)
            .flatMap(item -> Observable.range(1, item))
            .subscribe(
                item -> System.out.println("FlatMap item: " + item),
                throwable -> {},
                () -> System.out.println("Sequence complete.")
            );
    }
}
