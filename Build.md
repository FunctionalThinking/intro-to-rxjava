# RxJava 소스 체크아웃 후 빌드하기

    $ git clone git@github.com:ReactiveX/RxJava.git
    $ cd RxJava/
    $ ./gradlew build

클린 빌드하기

    $ ./gradlew clean build

# Gradle로 Java 프로젝트 빌드하기

1. libs 디렉토리 생성 후 rxjava-x.x.SNAPSHOT.jar 복사
2. build.gradle 파일 생성

      apply plugin: 'java'

      dependencies {
        compile fileTree(dir: 'libs', include: 'rxjava-1.0.9-SNAPSHOT.jar')
      }

3. 빌드하기

    $ gradle build

4. 실행하기

    $ cd ./build/libs
    $ java -jar HelloWorld.jar

# 참고 자료
- [Getting Started - RxJava](https://github.com/ReactiveX/RxJava/wiki/Getting-Started)
- [Java Quickstart - Gradle](https://gradle.org/docs/current/userguide/tutorial_java_projects.html)
