# RxJava 소스 체크아웃 후 빌드하기

빌드하기

    $ git clone https://github.com/ReactiveX/RxJava.git
    $ cd RxJava/
    $ ./gradlew build

`./build/libs` 디렉토리에서 jar 생성 확인

클린 빌드하기

    $ ./gradlew clean build

# Gradle로 Java 프로젝트 빌드하기

1. HelloWorld 루트 디렉토리 생성
2. libs 디렉토리 생성 후 jar 복사
3. src/main/java 디렉토리에 com/lge 패키지 생성
4. 패키지 내 HelloWorld.java 생성

    ```
    package com.lge;
    
    import rx.Observable;
    
    public class Grokking {
        public static void main(String [] args) {
            Observable.range(0, 3).subscribe(new Action1<Integer>() {
                @Override
	    		   public void call(Integer i) {
	    			    System.out.println("Hello RxJava");
	    			}
            });
	     }
    }

    ```

3. 루트 디렉토리에 build.gradle 파일 생성
4. build.gradle에 빌드 설정 추가

	```
	apply plugin: 'java'
	
	jar {
	    manifest {
	    	attributes: 'Main-Class': 'com.lge.HelloWorld'
	    }
	}
	    
	dependencies {
	    compile fileTree(dir: 'libs', include: '*.jar')
	}
	```

4. 빌드하기

	```
	$ gradle build
	```

5. 실행하기
	
	```
    $ cd ./build/libs
    $ java -jar HelloWorld.jar
    ```

# 참고 자료
- [RxJava - Getting Started](https://github.com/ReactiveX/RxJava/wiki/Getting-Started)
- [Gradle - Chapter 7. Java Quickstart](https://gradle.org/docs/current/userguide/tutorial_java_projects.html)
- [Getting Started with Gradle: Our First Java Project](http://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-our-first-java-project/)
