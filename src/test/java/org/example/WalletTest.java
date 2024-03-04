package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {


    @Test
    void testWithdrawSufficientCash() {
        final int UANG_AWAL = 120;
        Wallet wallet = new Wallet("Aha", UANG_AWAL, new ArrayList<>());

        wallet.withdraw(10);
        assertEquals(110, wallet.uangCash);
    }

    @Test
    void testWithdrawInsufficientCash() {
        final int UANG_AWAL = 120;
        Wallet wallet = new Wallet("Aha", UANG_AWAL, new ArrayList<>());

        assertThrows(Error.class, () -> {
            wallet.withdraw(1000);

        });

        assertEquals(120.0, wallet.uangCash);
    }


    @Test
    void testDeposit() {
        final int UANG_AWAL = 120;
        Wallet wallet = new Wallet("Aha", UANG_AWAL, new ArrayList<>());
        wallet.deposit(30.0);

        assertEquals(150.0, wallet.uangCash);
    }


    @Test
    void testAddCard() {
        Wallet wallet = new Wallet("Aha", 120, new ArrayList<>());
        wallet.addCard("card1");
        wallet.addCard("card2");
        assertAll(
                () -> assertTrue(wallet.listKartu.contains("card1")),
                () -> assertTrue(wallet.listKartu.contains("card2"))
        );
    }


    @Test
    void testRemoveCard() {
        ArrayList<String> cards = new ArrayList<>();
        cards.add("card1");
        Wallet wallet = new Wallet("Aha", 120, cards);

        wallet.removeCard("card1");

        assertFalse(wallet.listKartu.contains("card1"));
    }


    @Test
    void testRemoveNoneCard(){
        Wallet wallet = new Wallet("Aha", 120, new ArrayList<>());
        assertThrows(Error.class, () -> wallet.removeCard("card1"));
    }
}