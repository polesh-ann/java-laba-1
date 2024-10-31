package org.example;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.SystemInRule;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class MainTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final SystemInRule systemInRule = new SystemInRule();

    @Test
    public void testMainWithValidInput() {
        systemInRule.provideLines("1", "5"); // Вводим x=1 и k=5
        Main.main(new String[0]);
        assertThat(systemOutRule.getLog(), containsString("Вычислено через стандартную функцию:"));
    }

    @Test
    public void testMainWithInvalidK() {
        systemInRule.provideLines("1", "-1"); // Вводим x=1 и k=-1
        Main.main(new String[0]);
        assertThat(systemOutRule.getLog(), containsString("неправильное значение"));
    }
}
