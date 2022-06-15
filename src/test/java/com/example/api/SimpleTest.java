package com.example.api;

import com.example.api.annotations.Smoke;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@Smoke
public class SimpleTest {

    @BeforeAll
    public static void before() {
        System.out.println("Hello, I am first ");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("++++++++++");
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1", "test2"})
    public void mySimpleTest(String test) {
        System.out.println("Hello " + test);
    }

    @ParameterizedTest
    @EnumSource
    public void myEnum(Roles role) {
        System.out.println("Hello " + role);
    }

    @ParameterizedTest
    @EnumSource(names = {"MANAGER"})
    public void myEnumManager(Roles role) {
        System.out.println("Hello " + role);
    }

    @ParameterizedTest
    @EnumSource(names = {"MANAGER"}, mode = EnumSource.Mode.EXCLUDE)
    public void myEnumExclude(Roles role) {
        System.out.println("Hello " + role);
    }

    @ParameterizedTest
    @EnumSource(names = {".*MANAGER"}, mode = EnumSource.Mode.MATCH_ALL)
    public void myEnumPattern(Roles role) {
        System.out.println("Hello " + role);
    }

    @ParameterizedTest
    @MethodSource("sourceMethod")
    public void myEnumMethodSource(Roles role) {
        System.out.println("Hello " + role);
    }

    @Test
    public void mySimpleTest2() {
        System.out.println("Hello2");
    }


    @AfterEach
    public void afterEach() {
        System.out.println("=========");
    }


    @AfterAll
    public static void after() {
        System.out.println("Hello, I am last ");
    }

    public enum Roles{
        MANAGER,
        SENIOR_MANAGER,
        ADMIN
    }

    public static Stream<Roles> sourceMethod() {
         return Stream.of(Roles.ADMIN, Roles.MANAGER);
    }

}
