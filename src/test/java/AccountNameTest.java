import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountNameTest {
    private final String name;
    private final boolean embossible;

    public AccountNameTest(String name, boolean embossible){
        this.name = name;
        this.embossible = embossible;
    }

    @Parameterized.Parameters
    public static Object[][] checkNameToEmboss(){
        return new Object[][]{
                {"Настя Бурцева", true},
                {"раÖä47 Ёfgj#_!", true},
                {"НастяБурцева", false},
                {"Настя  Бурцева", false},
                {"А А Бурцева", false},
                {"А А", true},
                {"Йцукенгш Щзхъфывапр", true},
                {"Йцукенгш Щзхъфывапрй", false},
                {"", false},
                {" Настя Бурцева", false},
                {"Настя Бурцева ", false},
                {" НастяБурцева", false},
                {"НастяБурцева ", false},
                {null, false}
        };
    }

    @Test
    public void testCheckNameToEmboss(){
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        boolean expected = embossible;

        assertEquals(name + " is incorrect", expected, actual);
    }
}
