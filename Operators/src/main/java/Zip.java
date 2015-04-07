import rx.Observable;

public class Zip {
    public static void zip() {
        Observable<Integer> odds = Observable.just(1, 3, 5);
        Observable<Integer> evens = Observable.just(2, 4, 6);
        Observable.merge(odds, evens)
            .subscribe(
                item -> System.out.println("Zip item: " + item),
                throwable -> { },
                () -> System.out.println("Sequence completed.")
            );
    }
}
