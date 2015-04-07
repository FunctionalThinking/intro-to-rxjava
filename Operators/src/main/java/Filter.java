import rx.Observable;

public class Filter {
    public static void filter() {
        Observable.just(1, 2, 3, 4, 5)
            .filter(item -> item < 4)
            .subscribe(
                item -> System.out.println("Filter item: " + item),
                throwable -> {},
                () -> System.out.println("Sequence complete.")
            );
    }
}
