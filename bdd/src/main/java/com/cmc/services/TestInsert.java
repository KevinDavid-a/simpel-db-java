package com.cmc.services;

import com.cmc.entities.Test;

public class TestInsert {
    public static void main(String[] args) {

        Test test = new Test(4, "Vanessa");
        TestService.insert(test);
    }
}
