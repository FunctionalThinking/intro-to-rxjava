# Gradle로 Java 프로젝트 빌드하기

1. `HelloWorld` 루트 디렉토리 생성
2. `src/main/java` 디렉토리에 `com/lge` 패키지 생성
3. 패키지 내 `HelloWorld.java` 생성

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
4. `src/test/java` 디렉토리에  `com/lge` 패키지 생성
5. 패키지 내 'HelloWorldTest.java' 생성

    ```
    package com.lge;

    import static org.junit.Assert.*;
    import org.junit.*;

    public class HelloWorld {
        @Test
        public void testHelloWorld() {
            assertEquals("Hello World", "Hello World");
        }
    }
    ```

6. 루트 디렉토리에 `build.gradle` 파일 생성
7. `build.gradle`에 빌드 설정 추가

    ```
    // retrolambda를 위한 빌드 스크립트 설정
    buildscript {
        repositories {
            mavenCentral()
        }

        dependencies {
            classpath 'me.tatarka:gradle-retrolambda:3.0.0'
        }
    }

    // 의존성 관리를 위한 외부 저장소 지정
    repositories {
        mavenCentral()
    }

    // gradle 플러그인 - java, retrolambda
    apply plugin: 'java'
    apply plugin: 'me.tatarka.retrolambda'

    // retrolambda를 위한 JDK6 설정
    retrolambda {
        oldJdk System.getenv("JAVA6_HOME")
    }

    // jar 파일 패키징 설정
    jar {
        // 'fat' jar 생성을 위하여 의존성 포함시키기
        from {
            configurations.compile.collect {
                it.isDirectory() ? it : zipTree(it)
            }
        }
        // Manifest.mf - Main-Class 지정
        manifest {
            attributes 'Main-Class': 'com.lge.HelloWorld'
        }
    }

    // 의존성 관리를 위한 설정 - RxJava, JUnit
    dependencies {
        compile 'io.reactivex:rxjava:1.0.0'
        testCompile 'junit:junit:4.11'
    }
    ```

8. 테스트하기

    ```
    $ gradle test
    ```    

9. 빌드하기

    ```
    $ gradle build
    ```

10. 실행하기
	
    ```
    $ java -jar build/libs/HelloWorld.jar
    ```

# 참고 자료
- [RxJava - Getting Started](https://github.com/ReactiveX/RxJava/wiki/Getting-Started)
- [Gradle - Chapter 7. Java Quickstart](https://gradle.org/docs/current/userguide/tutorial_java_projects.html)
- [Getting Started with Gradle: Our First Java Project](http://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-our-first-java-project/)
- [Getting Started with Gradle: Dependency Management](http://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-dependency-management/)
- [Gradle Retrolambda Plugin](https://github.com/evant/gradle-retrolambda)
