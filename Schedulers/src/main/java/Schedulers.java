import rx.Observable;
import java.util.concurrent.CountDownLatch;

public class Schedulers {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch cdl = new CountDownLatch(1);
        Observable.create(subscriber -> {
            System.out.println("Observable: " + Thread.currentThread().getName());
            subscriber.onNext("");
            subscriber.onCompleted();
        })
        .subscribeOn(rx.schedulers.Schedulers.io())
        .observeOn(rx.schedulers.Schedulers.newThread())
        .subscribe(
                s -> System.out.println("Subscriber: " + Thread.currentThread().getName()),
                throwable -> {},
                () -> cdl.countDown()
        );
        cdl.await();
    }
}
