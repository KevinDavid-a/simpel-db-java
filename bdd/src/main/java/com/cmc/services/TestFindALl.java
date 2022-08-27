package com.cmc.services;

import com.cmc.entities.Test;

import java.util.ArrayList;

public class TestFindALl {
    public static void main(String[] args) {
        ArrayList<Test> tests = TestService.findAll();
        for (Test test : tests) {
            System.out.println(test);
        }
    }
}
