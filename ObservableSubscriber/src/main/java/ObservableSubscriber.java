import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

public class ObservableSubscriber {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Hello World");
        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() { }

            @Override
            public void onError(Throwable e) { }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });

        Observable.just("Hello World")
            .subscribe(new Action1<String>() {
                @Override
                public void call(String s) {
                    System.out.println(s);
                }
            });

        Observable.just("Hello World")
            .subscribe(s -> System.out.println(s));
    }
}