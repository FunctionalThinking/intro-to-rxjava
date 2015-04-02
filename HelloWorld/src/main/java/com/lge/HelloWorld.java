package com.lge;

import rx.Observable;
import rx.functions.Action1;

public class HelloWorld {
    public static void main(String [] args) {
        Observable.range(0, 3).subscribe(i -> {
                System.out.println("Hello RxJava");
            }
        );
    }
}