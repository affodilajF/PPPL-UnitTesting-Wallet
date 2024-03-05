package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Tugas pertemuan 3 => Menambahkan Life Cycle (Lifecylce.PER_METHOD)

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class WalletTest {
    private Wallet wallet;
    @BeforeEach
    void initMethod(){
        wallet = new Wallet("Aha", 120, new ArrayList<>(List.of("card1", "card2")));
    }
    @AfterEach
    void cleanMethod(){
        wallet = null;
    }
    @BeforeAll
    static void initClass(){}

    @AfterAll
    static void cleanClass(){}



    @Test
    void testObjectCreation(){
        String[] cardsExpected = {"card1", "card2"};
        String[] cardsActual = wallet.getListKartu().toArray(new String[0]);

        assertAll(
                "Grouped Assertions of Wallet Object",
                () -> assertEquals("Aha", wallet.getOwner()),
                () -> assertEquals(120, wallet.getUangCash()),
                () -> assertArrayEquals(cardsExpected, cardsActual)
        );
    }

    @Test
    void testWithdrawSufficientCash() {
        wallet.withdraw(10);
        assertEquals(110, wallet.getUangCash());
    }

    @Test
    void testWithdrawInsufficientCash() {
        assertThrows(Error.class, () -> {
            wallet.withdraw(1000);
        });
        assertEquals(120.0, wallet.getUangCash());
    }
    @Test
    void testDeposit() {
        wallet.deposit(30.0);
        assertEquals(150.0, wallet.getUangCash());
    }
    @Test
    void testAddCard() {
        wallet.addCard("card3");
        wallet.addCard("card4");
        assertAll(
                () -> assertTrue(wallet.getListKartu().contains("card3")),
                () -> assertTrue(wallet.getListKartu().contains("card4"))
        );
    }
    @Test
    void testRemoveCard() {
        wallet.removeCard("card2");
        assertFalse(wallet.getListKartu().contains("card2"));
    }
    @Test
    void testRemoveNoneCard(){
        assertThrows(Error.class, () -> wallet.removeCard("card5UUUU"));
    }


}