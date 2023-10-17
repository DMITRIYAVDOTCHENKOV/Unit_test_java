package org.example.solution.seminars.second.life_cycle_JUnit5;


import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestLC {
    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    void setupThis() {
        System.out.println("@BeforeEach");
    }

    @Test
    void testOne() {
        System.out.println("testOne");
    }

    @Test
    void testTwo() {
        System.out.println("testTwo");
    }

    @AfterEach
    void tearThis() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    static void tear() {
        System.out.println("@AfterAll");
    }
}
