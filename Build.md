# Gradle로 Java 프로젝트 빌드하기

1. HelloWorld 루트 디렉토리 생성
2. src/main/java 디렉토리에 com/lge 패키지 생성
3. 패키지 내 HelloWorld.java 생성

    ```
    package com.lge;
    
    import rx.Observable;
    
    public class Grokking {
        public static void main(String [] args) {
            Observable.range(0, 3).subscribe(i -> {
                System.out.println("Hello RxJava");
            });
        }
    }

    ```

4. 루트 디렉토리에 build.gradle 파일 생성
5. build.gradle에 빌드 설정 추가

	```
	// retrolambda를 위한 빌드 스크립트 교체
    buildscript {
        repositories {
            mavenCentral()
        }

        dependencies {
            classpath 'me.tatarka:gradle-retrolambda:3.0.0'
        }
    }

    // 외부 라이브러리 다운로드를 위한 저장소 설정
    repositories {
        mavenCentral()
    }

    // gradle 플러그인 - java, retrolambda
    apply plugin: 'java'
    apply plugin: 'me.tatarka.retrolambda'

    // jar 파일 패키징 설정
    jar {
        // 'fat' jar 생성을 위한 라이브러리 포함시키기
        from {
            configurations.compile.collect {
                it.isDirectory() ? it : zipTree(it)
            }
        }
        // Manifest.mf - Main-Class 설정
        manifest {
            attributes 'Main-Class': 'com.lge.HelloWorld'
        }
    }

    // 외부 라이브러리 다운로드 설정
    dependencies {
        compile 'io.reactivex:rxjava:1.0.0'
    }
	```

6. 빌드하기

	```
	$ gradle build
	```

7. 실행하기
	
	```
    $ java -jar build/libs/HelloWorld.jar
    ```


# 참고 자료
- [RxJava - Getting Started](https://github.com/ReactiveX/RxJava/wiki/Getting-Started)
- [Gradle - Chapter 7. Java Quickstart](https://gradle.org/docs/current/userguide/tutorial_java_projects.html)
- [Getting Started with Gradle: Our First Java Project](http://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-our-first-java-project/)
- [Getting Started with Gradle: Dependency Management](http://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-dependency-management/)
